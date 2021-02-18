package com.mypr.pms.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import com.mypr.pms.domain.BodyCheckMenu;
import com.mypr.util.Prompt;

public class BodyCheckingMenu {
  private ArrayList<BodyCheckMenu> bodyCheck = new ArrayList<>();
  private int count = 0;

  public void bodyCheck() {
    BodyCheckMenu b = new BodyCheckMenu();
    b.setDate(new Date(System.currentTimeMillis()));
    System.out.printf("입력일자 : [ %s ]\n", b.getDate());
    loop:
      while(true) {
        b.setTall(Prompt.inputDouble("키를 입력하세요.(cm)\n> "));
        b.setBadyWeight(Prompt.inputDouble("몸무게를 입력하세요.(xx.xkg)\n> "));
        b.setMuscleMass(Prompt.inputDouble("골격근량 입력하세요.(xx.x%%)\n> "));
        b.setBodyFatMass(Prompt.inputDouble("체지방률 입력하세요.(xx.x%%)\n> "));
        if(reInput()) {
          break;
        } else {
          continue loop;
        }
      }
    massage("기록이 등록되었습니다.");
    count++;
    b.setNum(count);
    bodyCheck.add(b);
  }

  public void checkRecode() throws CloneNotSupportedException {
    Iterator<BodyCheckMenu> iterator = bodyCheck.iterator();
    if (count == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    } else {
      while (iterator.hasNext()) {
        BodyCheckMenu b = iterator.next();
        System.out.printf("\n%d > [ %s ]"
            + "\n키 : %.2f"
            + "\n몸무게 : %.2f"
            + "\n골격근량 : %.2f"
            + "\n체지방량 : %.2f"
            + "\n===================="
            , b.getNum(), b.getDate(), b.getTall(), b.getBadyWeight(), b.getMuscleMass(), b.getBodyFatMass());
      }
    }

    int number2 = Prompt.inputInt("\n1.update\n2.Delete\n3.뒤로가기\n> ");
    int no = Prompt.inputInt("몇번 정보를 수정하시겠습니까?");
    switch(number2) {
      case 1:
        update(no);
        break;
      case 2:
        delete(no);
        break;
      case 3:
        break;
    }
  }

  public void graph() throws CloneNotSupportedException {
    BodyCheckMenu[] b = bodyCheck.toArray(new BodyCheckMenu[count]);
    if (b.length == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    for (BodyCheckMenu b1 : b) {
      System.out.printf("\n[골격근량 : %.2f]", b1.getBodyFatMass());
      for (int i = 0; i < (int) b1.getBodyFatMass(); i++) {
        System.out.print("*");
      }
    }
    System.out.println();

  }

  public void update(int number) {
    BodyCheckMenu b = findByNo(number);
    if (b == null) {
      massage("입력된 정보가 없습니다.");
      return;
    }
    while(true) {
      int choice = Prompt.inputInt("\n어떤것을 수정하시겠습니까?"
          + "\n1. 키"
          + "\n2. 몸무게"
          + "\n3. 골격근량"
          + "\n4. 체지방량"
          + "\n> ");
      switch (choice) {
        case 1:
          b.setTall(Prompt.inputDouble("키> "));
          break;
        case 2:
          b.setBadyWeight(Prompt.inputDouble("몸무게> "));
          break;
        case 3:
          b.setMuscleMass(Prompt.inputDouble("골격근량> " ));
          break;
        case 4:
          b.setBodyFatMass(Prompt.inputDouble("체지방량> "));
          break;
        default :
          System.out.printf("\n없는 번호입니다.\n");
          continue;
      }
      if(reInput()) {
        continue;
      }
      break;
    }

    System.out.println();
    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) > ");
    if (input.equalsIgnoreCase("y")) {
      massage("기록을 변경하였습니다.");
    } else {
      massage("기록변경을 취소하였습니다.");
    }
  }

  public void delete(int number) {
    BodyCheckMenu b = findByNo(number);
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    if (input.equalsIgnoreCase("y")) {

      int index = number + 1;
      b = findByNo(index);
      while (b != null) {
        b = findByNo(index);
        b.setNum(b.getNum() - 1);
        index++;
      }

      bodyCheck.remove(b);
      massage("기록을 삭제하였습니다.");
    } else {
      massage("기록삭제를 취소하였습니다.");
    }
  }


  boolean reInput() {
    while(true) {
      String str = Prompt.inputString("이대로 입력하시겠습니까? (y/N) > ");
      if(str.equalsIgnoreCase("y")) {
        return true;
      } else if (str.equalsIgnoreCase("n")) {
        return false;
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
    }
  }

  public static void massage(String massage) {
    System.out.printf("\n-------------------------------\n"
        + "%s"
        + "\n-------------------------------\n", massage);
  }

  private BodyCheckMenu findByNo(int bodyNo) {
    BodyCheckMenu[] list = bodyCheck.toArray(new BodyCheckMenu[count]);
    for (BodyCheckMenu m : list) {
      if (m.getNum() == bodyNo) {
        return m;
      }
    }
    return null;
  }

}
