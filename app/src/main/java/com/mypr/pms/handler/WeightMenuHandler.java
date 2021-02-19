package com.mypr.pms.handler;

import java.sql.Date;
import java.util.LinkedList;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.pms.domain.WeightTotal;
import com.mypr.util.Prompt;

public class WeightMenuHandler {

  private LinkedList<BodyBuilding> weightList = new LinkedList<>();
  private int count = 0;

  public void weightWorkMenu() {
    BodyBuilding w = new BodyBuilding();
    System.out.printf("\n현재까지 진행한 회차는(%d)회 입니다.", count);
    w.setNums(Prompt.inputInt("\n회차를 입력해주세요 : "));
    loop:
      while(true) {
        int i = Prompt.inputInt("\n1.전면\n2.팔\n3.뒤로가기\n> ");
        switch(i) {
          case 1:
            w.setdPress(Prompt.inputInt("덤벨프레스 > "));
            w.setInDpress(Prompt.inputInt("IN.프레스 > "));
            w.setdFly(Prompt.inputInt("덤벨플라이 > "));
            w.setInFly(Prompt.inputInt("IN.플라이 > "));
            w.setDumbellPullover(Prompt.inputInt("덤벨풀오버 > "));
            break;
          case 2:
            w.setBicepsCurl(Prompt.inputInt("이두덤벨컬 > "));
            w.setTricepOver(Prompt.inputInt("오버헤드익스텐션 > "));
            w.setLateralRaise(Prompt.inputInt("레터럴라이즈 > "));
            w.setShoulderPress(Prompt.inputInt("숄더프레스 > "));
            w.setBentoverLateral(Prompt.inputInt("벤트오버 > "));
            break;
          case 3:
            massage("입력을 취소하였습니다.");
            return;
          default :
            massage("재입력 바랍니다.");
            continue loop;
        }
        if(reInput()) {
          continue loop;
        }
        w.setDate(new Date(System.currentTimeMillis()));
        break;
      }
    count++;
    weightList.add(w);
    massage("기록이 등록되었습니다.");
  }


  public void weightRecodeList() {
    System.out.println();
    BodyBuilding[] weightMenu = weightList.toArray(new BodyBuilding[count]);
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
      massage("입력된 정보가 없습니다.");
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
      massage("기록을 변경하였습니다.");
    } else {
      massage("기록변경을 취소하였습니다.");
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

      weightList.remove(c);
      massage("기록을 삭제하였습니다.");
    } else {
      massage("기록삭제를 취소하였습니다.");
    }
  }

  public void weightTotal() {
    WeightTotal t = new WeightTotal();
    BodyBuilding[] wMenu = weightList.toArray(new BodyBuilding[count]); 
    if (wMenu.length == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    for (BodyBuilding w : wMenu) {
      t.setdPress(t.getdPress() + w.getdPress());
      t.setInDpress(t.getInDpress() + w.getInDpress());
      t.setdFly(t.getdFly() + w.getdFly());
      t.setInFly(t.getInFly() + w.getInFly());
      t.setBicepsCurl(t.getBicepsCurl() + w.getBicepsCurl());
      t.setTricepOver(t.getTricepOver() + w.getTricepOver());
      t.setLateralRaise(t.getLateralRaise() + w.getLateralRaise());
      t.setShoulderPress(t.getShoulderPress() + w.getShoulderPress());
      t.setBentoverLateral(t.getBentoverLateral() + w.getBentoverLateral());
      t.setDumbellPullover(t.getDumbellPullover() + w.getDumbellPullover());

    }
    System.out.printf("\n[운동횟수:%d회]\n", count);
    System.out.println("-----[가  슴]-----");
    System.out.printf("덤벨프레스 : %d회\n", t.getdPress());
    System.out.printf("IN.프 레 스: %d회\n", t.getInDpress());
    System.out.printf("덤벨플라이 : %d회\n", t.getdFly());
    System.out.printf("IN.플 라 이: %d회\n", t.getInFly());
    System.out.printf("덤벨 풀오버 : %d회\n", t.getDumbellPullover());
    System.out.println("-----[  팔  ]-----");
    System.out.printf("이두 덤벨컬 : %d회\n", t.getBicepsCurl());
    System.out.printf("오버헤드익스: %d회\n", t.getTricepOver());
    System.out.println("-----[어  깨]-----");
    System.out.printf("레터럴라이즈: %d회\n", t.getLateralRaise());
    System.out.printf("숄더 프레스 : %d회\n", t.getShoulderPress());
    System.out.printf("벤 트 오 버 : %d회\n", t.getBentoverLateral());
  }

  public void recodeOutput(String work, int totals) {
    if(totals > 0) {
      System.out.printf(work, totals);
    }
  }

  public static void massage(String massage) {
    System.out.printf("\n-------------------------------\n"
        + "%s"
        + "\n-------------------------------\n", massage);
  }

  boolean reInput() {
    while(true) {
      String str = Prompt.inputString("계속 입력하시겠습니까? (y/N) > ");
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


  private BodyBuilding findByNo(int weightNo) {
    BodyBuilding[] list = weightList.toArray(new BodyBuilding[count]);
    for (BodyBuilding w : list) {
      if (w.getNums() == weightNo) {
        return w;
      }
    }
    return null;
  }


}