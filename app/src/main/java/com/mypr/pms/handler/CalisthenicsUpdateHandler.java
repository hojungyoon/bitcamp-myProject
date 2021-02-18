package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class CalisthenicsUpdateHandler extends AbstractCalisthenicsHandler {

  public CalisthenicsUpdateHandler (List<Calisthenics> calisList) {
    super (calisList);
  }

  @Override
  public void service(int number) {
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
          + "\n7. 러닝"
          + "\n8. 등산"
          + "\n9. 배틀로프"
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
        case 7:
          c.setRunning(Prompt.inputInt("러닝> "));
          if (c.getRunning() >= 10) {
            c.setMarathonName(Prompt.inputString("대회 이름 > "));
            if(c.getMarathonName() == "") {
              String practice = "연습";
              c.setMarathonName(practice);
            }
          }
          break;
        case 8:
          c.setHiking(Prompt.inputInt("등산> "));
          break;
        case 9:
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

  @Override
  public void service() {}
}

