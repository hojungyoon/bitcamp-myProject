package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.util.Prompt;

public class BodyBuildingListHandler extends AbstractBodyBuildingHandler {

  public BodyBuildingListHandler (List<BodyBuilding> bodyBuildingList) {
    super (bodyBuildingList);
  }

  @Override
  public void service() {
    System.out.println();
    BodyBuilding[] weightMenu = bodyBuildingList.toArray(new BodyBuilding[bodyBuildingList.size()]);
    if (weightMenu.length == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    for (BodyBuilding w : weightMenu) {
      System.out.printf("[%d회차. %s]\n", w.getNums(), w.getDate());
    }
    wTodayRecode();

  }

  public void wTodayRecode() {
    int no = Prompt.inputInt("> ");
    BodyBuilding w = findByNo(no);
    if (no == w.getNums()) {
      System.out.printf("\n[%d회차]: %s\n", w.getNums(), w.getDate());
      System.out.println("-----[전  면]-----");
      recodeOutput("덤벨프레스 : %d회\n", w.getdPress());
      recodeOutput("IN.프 레 스: %d회\n", w.getInDpress());
      recodeOutput("덤벨플라이 : %d회\n", w.getdFly());
      recodeOutput("IN.플 라 이: %d회\n", w.getInFly());
      recodeOutput("덤벨 풀오버 : %d회]\n", w.getDumbellPullover());
      System.out.println("-----[  팔  ]-----");
      recodeOutput("이두 덤벨컬 : %d회\n", w.getBicepsCurl());
      recodeOutput("오버헤드익스: %d회\n", w.getTricepOver());
      System.out.println("-----[어  깨]-----");
      recodeOutput("레터럴라이즈: %d회\n", w.getLateralRaise());
      recodeOutput("숄더 프레스 : %d회\n", w.getShoulderPress());
      recodeOutput("벤 트 오 버 : %d회\n", w.getBentoverLateral());

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
    BodyBuilding w = findByNo(number);
    if (w == null) {
      lineMessage("입력된 정보가 없습니다.");
      return;
    }
    while(true) {
      int choice = Prompt.inputInt("\n어떤것을 수정하시겠습니까?"
          + "\n1. 덤벨프레스"
          + "\n2. IN.프레스"
          + "\n3. 덤벨플라이"
          + "\n4. IN.플라이"
          + "\n5. 덤벨풀오버"
          + "\n6. 이두"
          + "\n7. 삼두"
          + "\n8. 레터럴라이즈"
          + "\n9. 숄더프레스"
          + "\n10. 벤트오버"
          + "\n> ");
      switch (choice) {
        case 1:
          w.setdPress(Prompt.inputInt("덤벨프레스> "));
          break;
        case 2:
          w.setInDpress(Prompt.inputInt("IN.프레스> "));
          break;
        case 3:
          w.setInFly(Prompt.inputInt("IN.플라이> " ));
          break;
        case 4:
          w.setDumbellPullover(Prompt.inputInt("덤벨풀오버> "));
          break;
        case 5:
          w.setBicepsCurl(Prompt.inputInt("이두> "));
          break;
        case 6:
          w.setBicepsCurl(Prompt.inputInt("삼두> "));
          break;
        case 7:
          w.setLateralRaise(Prompt.inputInt("레터럴라이즈> "));
          break;
        case 10:
          w.setShoulderPress(Prompt.inputInt("숄더프레스> "));
          break;
        case 11:
          w.setBentoverLateral(Prompt.inputInt("벤트오버> "));
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
    BodyBuilding c = findByNo(number);
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    if (input.equalsIgnoreCase("y")) {

      int index = number + 1;
      c = findByNo(index);
      while (c != null) {
        c = findByNo(index);
        c.setNums(c.getNums() - 1);
        index++;
      }

      bodyBuildingList.remove(c);
      lineMessage("기록을 삭제하였습니다.");
    } else {
      lineMessage("기록삭제를 취소하였습니다.");
    }
  }

}