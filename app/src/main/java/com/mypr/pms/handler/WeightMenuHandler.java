package com.mypr.pms.handler;

import com.mypr.pms.Prompt;
import com.mypr.pms.domain.WeightMenu;
import com.mypr.pms.domain.WeightTotal;

public class WeightMenuHandler {
  static final int SIZE = 100;

  WeightMenu[] wMenus = new WeightMenu[SIZE];

  int wCount = 0;

  public void weightWorkMenu() {
    WeightMenu w1 = new WeightMenu();

    loop:
      while(true) {
        int i = Prompt.inputInt("==============================\n"
            + "1.상체\n2.하체\n3.유산소\n4.뒤로가기\n> ");

        switch(i) {
          case 1:
            loop1:
              while(true) {
                int i2 = Prompt.inputInt("1.전면\n2.팔\n> ");

                switch(i2) {
                  case 1:
                    w1.dPress = Prompt.inputInt("덤벨프레스 > ");
                    w1.inDpress = Prompt.inputInt("IN.프레스 > ");
                    w1.dFly = Prompt.inputInt("덤벨플라이 > ");
                    w1.inFly = Prompt.inputInt("IN.플라이 > ");
                    w1.dumbellPullover = Prompt.inputInt("덤벨풀오버 > ");

                  case 2:
                    w1.dPress = Prompt.inputInt("덤벨프레스 > ");
                    w1.inDpress = Prompt.inputInt("IN.프레스 > ");
                    w1.dFly = Prompt.inputInt("덤벨플라이 > ");
                    w1.inFly = Prompt.inputInt("IN.플라이 > ");
                    w1.dumbellPullover = Prompt.inputInt("덤벨풀오버 > ");
                    break;
                  default :
                    System.out.println("재입력 바랍니다.");
                    continue loop1;
                }
                break;
              }
            break;
          default :
            System.out.println("재입력 바랍니다.");
            continue loop;
        }
        if(reInput() == true) {
          continue loop;
        }
        break;
      }
    if (w1.dPress > 0 ||
        w1.inDpress > 0 ||
        w1.dFly > 0 ||
        w1.inDpress > 0 ||
        w1.bicepsCurl > 0 ||
        w1.tricepOver > 0 ||
        w1.lateralRaise > 0 ||
        w1.shoulderPress > 0 ||
        w1.bentoverLateral > 0 ||
        w1.dumbellPullover > 0) {
      System.out.println("==============================");
      w1.day = Prompt.inputString("Weight Day > ");
      wMenus[wCount++] = w1;
    }
  }


  boolean reInput() {
    loop2:
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

  public void weightRecode() {
    for (int i = 0; i < this.wCount; i++) {
      WeightMenu w = this.wMenus[i];
      System.out.printf("\n==============================\n");
      System.out.printf("[%d회차]: %s\n", i+1, w.day);
      System.out.println("-----[가  슴]-----");
      recodeOutput("덤벨프레스 : %d회\n", w.dPress);
      recodeOutput("IN.프 레 스: %d회\n", w.inDpress);
      recodeOutput("덤벨플라이 : %d회\n", w.dFly);
      recodeOutput("IN.플 라 이: %d회\n", w.inDpress);
      System.out.println("-----[  팔  ]-----");
      recodeOutput("이두 덤벨컬 : %d회\n", w.bicepsCurl);
      recodeOutput("오버헤드익스: %d회\n", w.tricepOver);
      System.out.println("-----[어  깨]-----");
      recodeOutput("레터럴라이즈: %d회\n", w.lateralRaise);
      recodeOutput("숄더 프레스 : %d회\n", w.shoulderPress);
      recodeOutput("벤 트 오 버 : %d회\n", w.bentoverLateral);
      System.out.println("-----[전  면]-----");
      recodeOutput("덤벨 풀오버 : %dKm\n", w.dumbellPullover);
      System.out.println("==============================");
    }
  }

  public void weightTotal() {
    WeightTotal w = new WeightTotal();
    for (int i = 0; i < this.wCount; i++) {
      WeightMenu wt = this.wMenus[i];
      w.today = i+1;
      w.dPress += wt.dPress;
      w.inDpress+= wt.inDpress;
      w.dFly += wt.dFly;
      w.inFly += wt.inFly;
      w.bicepsCurl += wt.bicepsCurl;
      w.tricepOver += wt.tricepOver;
      w.lateralRaise += wt.lateralRaise;
      w.shoulderPress += wt.shoulderPress;
      w.bentoverLateral += wt.bentoverLateral;
      w.dumbellPullover += wt.dumbellPullover;

    }
    System.out.printf("==============================\n");
    System.out.printf("[운동횟수:%d회]\n", w.today);
    System.out.println("-----[가  슴]-----");
    System.out.printf("덤벨프레스 : %d회\n", w.dPress);
    System.out.printf("IN.프 레 스: %d회\n", w.inDpress);
    System.out.printf("덤벨플라이 : %d회\n", w.dFly);
    System.out.printf("덤벨 풀오버 : %d회\n", w.dumbellPullover);
    System.out.println("-----[  팔  ]-----");
    System.out.printf("이두 덤벨컬 : %d회\n", w.bicepsCurl);
    System.out.printf("오버헤드익스: %d회\n", w.tricepOver);
    System.out.println("-----[어  깨]-----");
    System.out.printf("레터럴라이즈: %d회\n", w.lateralRaise);
    System.out.printf("숄더 프레스 : %d회\n", w.shoulderPress);
    System.out.printf("벤 트 오 버 : %d회\n", w.bentoverLateral);
    System.out.println("==============================");
  }

  public void recodeOutput(String work, int totals) {
    if(totals > 0) {
      System.out.printf(work, totals);
    }
  }
}