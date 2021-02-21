package com.mypr.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.mypr.pms.domain.BodyCheck;
import com.mypr.util.Prompt;

public class BodyCheckingListHandler extends AbstractBodyCheckingHandler {

  public BodyCheckingListHandler (List<BodyCheck> bodyCheckList) {
    super (bodyCheckList);
  }

  @Override
  public void service() {
    Iterator<BodyCheck> iterator = bodyCheckList.iterator();
    if (bodyCheckList.size() == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    } else {
      while (iterator.hasNext()) {
        BodyCheck b = iterator.next();
        System.out.printf("\n%d > [ %s ]"
            + "\n키 : %.1fCm"
            + "\n몸무게 : %.1fKg"
            + "\n골격근량 : %.1f%%"
            + "\n체지방량 : %.1f%%"
            + "\n===================="
            , b.getNum(), b.getDate(), b.getTall(), b.getBadyWeight(), b.getMuscleMass(), b.getBodyFatMass());
      }
    }

    int number2 = Prompt.inputInt("\n1.update\n2.Delete\n3.뒤로가기\n> ");
    int no;

    switch(number2) {
      case 1:
        no = Prompt.inputInt("몇번 정보를 수정하시겠습니까?");
        update(no);
        break;
      case 2:
        no = Prompt.inputInt("몇번 정보를 수정하시겠습니까?");
        delete(no);
        break;
      case 3:
        return;
    }
  }

  public void update(int number) {
    BodyCheck b = findByNo(number);
    if (b == null) {
      lineMessage("입력된 정보가 없습니다.");
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
      lineMessage("기록을 변경하였습니다.");
    } else {
      lineMessage("기록변경을 취소하였습니다.");
    }
  }

  public void delete(int number) {
    BodyCheck b = findByNo(number);
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    if (input.equalsIgnoreCase("y")) {

      int index = number + 1;
      b = findByNo(index);
      while (b != null) {
        b = findByNo(index);
        b.setNum(b.getNum() - 1);
        index++;
      }

      bodyCheckList.remove(b);
      lineMessage("기록을 삭제하였습니다.");
    } else {
      lineMessage("기록삭제를 취소하였습니다.");
    }
  }

}
