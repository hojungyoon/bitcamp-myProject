package com.mypr.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.mypr.pms.domain.Cardio;
import com.mypr.util.Prompt;

public class CardioListHandler extends AbstractCardioHandler {

  public CardioListHandler (List<Cardio> cardioList) {
    super (cardioList);
  }

  @Override
  public void service() {
    Iterator<Cardio> iterator = cardioList.iterator();
    if (cardioList.size() == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    } else {
      while (iterator.hasNext()) {
        Cardio c = iterator.next();
        System.out.printf("[%d회차. %s]\n", c.getNum(), c.getDate());
      }

      int no = Prompt.inputInt("입력> ");
      Cardio c1 = findByNo(no);
      if (no == c1.getNum()) {
        System.out.println("-----[유산소]-----");
        recodeOutput("러     닝: %dKm\n", c1.getRunning());
        recodeOutput("등     산: %d분\n", c1.getHiking());
        recodeOutput("배틀 로프: %d분\n", c1.getRope());
        System.out.println("------------------------------");

        int number2 = Prompt.inputInt("\n1.update\n2.Delete\n3.뒤로가기\n> ");
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
    }
  }

  public void update(int number) {
    Cardio c = findByNo(number);
    if (c == null) {
      lineMessage("입력된 정보가 없습니다.");
      return;
    }
    while(true) {
      int choice = Prompt.inputInt("\n어떤것을 수정하시겠습니까?"
          + "\n1. 러닝"
          + "\n2. 등산"
          + "\n3. 배틀로프"
          + "\n> ");
      switch (choice) {
        case 1:
          c.setRunning(Prompt.inputInt("러닝> "));
          if (c.getRunning() >= 10) {
            c.setMarathonName(Prompt.inputString("대회 이름 > "));
            if(c.getMarathonName() == "") {
              String practice = "연습";
              c.setMarathonName(practice);
            }
          }
          break;
        case 2:
          c.setHiking(Prompt.inputInt("등산> "));
          break;
        case 3:
          c.setHiking(Prompt.inputInt("배틀로프> "));
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
    Cardio c = findByNo(number);
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    if (input.equalsIgnoreCase("y")) {

      cardioList.remove(c);
      lineMessage("기록을 삭제하였습니다.");
    } else {
      lineMessage("기록삭제를 취소하였습니다.");
    }
  }




}

