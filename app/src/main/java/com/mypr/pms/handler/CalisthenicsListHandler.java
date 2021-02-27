package com.mypr.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class CalisthenicsListHandler extends AbstractCalisthenicsHandler {

  public CalisthenicsListHandler (List<Calisthenics> calisList) {
    super (calisList);

  }

  @Override
  public void service(){
    System.out.println();
    //    Calisthenics[] calisMenu = calisList.toArray(new Calisthenics[count]);
    //    if(calisMenu.length == 0) {
    //      System.out.println("\n입력된 정보가 없습니다.\n");
    //      return;
    //    }  
    //    for(Calisthenics c : calisMenu) {
    //      System.out.printf("[%d회차. %s]\n", c.getNums(), c.getDate());
    //    }
    //    cTodayRecode();
    //  }

    Iterator<Calisthenics> iterator = calisList.iterator();
    if (calisList.size() == 0) {
      System.out.println("\n입력된 정보가 없습니다.\n");
      return;
    } else { 
      while (iterator.hasNext()) {
        Calisthenics c = iterator.next();
        System.out.printf("[%d회차. %s]\n", c.getNums(), c.getDate());
      }
      todayRecode();
    }
  }

  void todayRecode() {
    int no = Prompt.inputInt("> ");
    Calisthenics c1 = findByNo(no);
    if (no == c1.getNums()) {
      System.out.printf("\n[%d회차]: %s\n", c1.getNums(), c1.getDate());
      System.out.println("-----[상  체]-----");
      recodeOutput("푸 쉬 업 : %d회\n", c1.getPushUp());
      recodeOutput("딥스&스윙: %d회\n", c1.getDipping());
      recodeOutput("풀     업: %d회\n", c1.getChinning());
      recodeOutput("행잉-레그: %d회\n", c1.gethLegRaise());
      System.out.println("-----[하  체]-----");
      recodeOutput("스 쿼 트 : %d회\n", c1.getSquat());
      recodeOutput("런     지: %d회\n", c1.getLunge());
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

  public void update(int number) {
    Calisthenics c = findByNo(number);
    if (c == null) {
      lineMessage("입력된 정보가 없습니다.");
      return;
    }
    while(true) {
      int choice = Prompt.inputInt("\n어떤것을 수정하시겠습니까?"
          + "\n1. 푸쉬업"
          + "\n2. 딥스&스윙"
          + "\n3. 풀업"
          + "\n4. 행잉-레그"
          + "\n5. 스쿼트"
          + "\n6. 런지"
          + "\n> ");
      switch (choice) {
        case 1:
          c.setPushUp(Prompt.inputInt("푸쉬업> "));
          break;
        case 2:
          c.setDipping(Prompt.inputInt("딥스&스윙> "));
          break;
        case 3:
          c.setChinning(Prompt.inputInt("풀업> " ));
          break;
        case 4:
          c.sethLegRaise(Prompt.inputInt("행잉-레그> "));
          break;
        case 5:
          c.setSquat(Prompt.inputInt("스쿼트> "));
          break;
        case 6:
          c.setLunge(Prompt.inputInt("런지> "));
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
    Calisthenics c = findByNo(number);
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    if (input.equalsIgnoreCase("y")) {

      calisList.remove(c);
      lineMessage("기록을 삭제하였습니다.");
    } else {
      lineMessage("기록삭제를 취소하였습니다.");
    }
  }



}

