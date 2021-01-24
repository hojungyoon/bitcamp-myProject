package com.mypr.pms.handler;

import com.mypr.pms.Prompt;
import com.mypr.pms.domain.CalisthenicsTotal;
import com.mypr.pms.domain.CalisthenicshMenu;
import com.mypr.pms.domain.WeightMenu;
import com.mypr.pms.domain.WeightTotal;

public class WorkOutMenuHandler {
  static final int SIZE = 100;

  CalisthenicshMenu[] cMenus = new CalisthenicshMenu[SIZE];
  WeightMenu[] wMenus = new WeightMenu[SIZE];

  int cCount = 0;
  int wCount = 0;

  public void workMenu() {
    CalisthenicshMenu c1 = new CalisthenicshMenu();
    WeightMenu w1 = new WeightMenu();

    loop:
      while(true) {
        int i = Prompt.inputInt("==============================\n"
            + "1.상체\n2.하체\n3.유산소\n4.뒤로가기\n> ");

        switch(i) {
          case 1:
            loop1:
              while(true) {
                int i2 = Prompt.inputInt("1.전면\n2.후면\n3.팔\n4.복부\n> ");

                switch(i2) {
                  case 1:
                    int choice = Prompt.inputInt("1.캘리스\n2.웨이트\n> ");

                    while(true) {
                      if(choice == 1) {
                        c1.pushUp = Prompt.inputInt("푸쉬업 > ");
                        c1.dipping = Prompt.inputInt("딥스 > ");
                        break;
                      } else if (choice == 2) {
                        w1.dPress = Prompt.inputInt("덤벨프레스 > ");
                        w1.inDpress = Prompt.inputInt("IN.프레스 > ");
                        w1.dFly = Prompt.inputInt("덤벨플라이 > ");
                        w1.inFly = Prompt.inputInt("IN.플라이 > ");
                        w1.dumbellPullover = Prompt.inputInt("덤벨풀오버 > ");
                        break;
                      } else {
                        System.out.println("재입력 해주세요.");
                        continue;
                      }
                    }
                    break;

                  case 2:
                    c1.chinning = Prompt.inputInt("풀업 > ");

                    break;
                  case 3:
                    int choice2 = Prompt.inputInt("1.캘리스\n2.웨이트\n> ");

                    while(true) {
                      if(choice2 == 1) {
                        c1.biceps = Prompt.inputInt("이두 > ");
                        c1.triceps = Prompt.inputInt("삼두 > ");
                        c1.shoulder = Prompt.inputInt("어깨 > ");
                        break;
                      } else if (choice2 == 2) {
                        w1.bicepsCurl = Prompt.inputInt("이두덤벨컬 > ");
                        w1.tricepOver = Prompt.inputInt("오버헤드익스텐션 > ");
                        w1.lateralRaise = Prompt.inputInt("레터럴라이즈 > ");
                        w1.shoulderPress = Prompt.inputInt("숄더프레스 > ");
                        w1.bentoverLateral = Prompt.inputInt("벤트오버 > ");
                        break;
                      } else {
                        System.out.println("재입력 해주세요.");
                        continue;
                      }
                    }
                    break;

                  case 4:
                    c1.hLegRaise = Prompt.inputInt("복부 > ");
                    break;
                  default :
                    System.out.println("재입력 바랍니다.");
                    continue loop1;

                }
                break;
              }
            break;

          case 2:
            c1.squat = Prompt.inputInt("스쿼트 > ");
            c1.lunge= Prompt.inputInt("런지 > ");
            break;

          case 3:
            c1.running = Prompt.inputInt("러 닝(km) > ");
            c1.hiking = Prompt.inputInt("등산(분) > ");
            c1.rope =  Prompt.inputInt("배틀로프 > ");
            break;

          case 4:
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

    if (c1.pushUp > 0 ||
        c1.dipping > 0 ||
        c1.chinning > 0 ||
        c1.hLegRaise > 0 ||
        c1.squat > 0 ||
        c1.lunge > 0 ||
        c1.biceps > 0 ||
        c1.triceps > 0 ||
        c1.shoulder > 0 ||
        c1.running > 0 ||
        c1.hiking > 0 ||
        c1.rope> 0) {
      System.out.println("==============================");
      c1.day = Prompt.inputString("Calisthenics Day > ");
      cMenus[cCount++] = c1;
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

  public void calisRecode() {
    for (int i = 0; i < this.cCount; i++) {
      CalisthenicshMenu c = this.cMenus[i];
      System.out.printf("\n==============================\n");
      System.out.printf("[%d회차]: %s\n", i+1, c.day);
      System.out.println("-----[상  체]-----");
      recodeOutput("푸 쉬 업 : %d회\n", c.pushUp);
      recodeOutput("딥스&스윙: %d회\n", c.dipping);
      recodeOutput("풀     업: %d회\n", c.chinning);
      recodeOutput("행잉-레그: %d회\n", c.hLegRaise);
      System.out.println("-----[하  체]-----");
      recodeOutput("스 쿼 트 : %d회\n", c.squat);
      recodeOutput("런     지: %d회\n", c.lunge);
      System.out.println("-----[  팔  ]-----");
      recodeOutput("이     두: %d회\n", c.biceps);
      recodeOutput("삼     두: %d회\n", c.triceps);
      recodeOutput("어     깨: %d회\n", c.shoulder);
      System.out.println("-----[유산소]-----");
      recodeOutput("러     닝: %dKm\n", c.running);
      recodeOutput("등     산: %d분\n", c.hiking);
      recodeOutput("배틀 로프: %d회\n", c.rope);
      System.out.println("==============================");
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

  public void calisTotal() {
    CalisthenicsTotal t = new CalisthenicsTotal();

    for (int a = 0; a < this.cCount; a++) {
      t.day = a+1;
      t.pushUp += this.cMenus[a].pushUp;
      t.dipping += this.cMenus[a].dipping;
      t.chinning += this.cMenus[a].chinning;
      t.hLegRaise += this.cMenus[a].hLegRaise;
      t.squat += this.cMenus[a].squat;
      t.lunge += this.cMenus[a].lunge;
      t.biceps += this.cMenus[a].biceps;
      t.triceps += this.cMenus[a].triceps;
      t.shoulder += this.cMenus[a].shoulder;
      t.running += this.cMenus[a].running;
      t.hiking += this.cMenus[a].hiking;
      t.rope += this.cMenus[a].rope;

    }
    System.out.printf("==============================\n");
    System.out.printf("[운동횟수:%d회]\n", t.day);
    System.out.println("-----[상  체]-----");
    System.out.printf("푸 쉬 업 : %d회\n", t.pushUp);
    System.out.printf("딥스&스윙: %d회\n", t.dipping);
    System.out.printf("행잉-레그: %d회\n", t.hLegRaise);
    System.out.println("-----[하  체]-----");
    System.out.printf("스 쿼 트 : %d회\n", t.squat);
    System.out.printf("런     지: %d회\n", t.lunge);
    System.out.println("-----[  팔  ]-----");
    System.out.printf("이     두: %d회\n", t.biceps);
    System.out.printf("삼     두: %d회\n", t.triceps);
    System.out.printf("어     깨: %d회\n", t.shoulder);
    System.out.println("-----[유산소]-----");
    System.out.printf("러     닝: %dkm\n", t.running);
    System.out.printf("등     산: %d분\n", t.hiking);
    System.out.printf("배틀 로프: %d회\n", t.rope);
    System.out.println("==============================");
  }


  public void weightTotal() {
    WeightTotal w = new WeightTotal();


    for (int i = 0; i < this.wCount; i++) {
      w.today = i+1;
      w.dPress += wMenus[i].dPress;
      w.inDpress+= wMenus[i].inDpress;
      w.dFly += wMenus[i].dFly;
      w.inFly += wMenus[i].inFly;
      w.bicepsCurl += wMenus[i].bicepsCurl;
      w.tricepOver += wMenus[i].tricepOver;
      w.lateralRaise += wMenus[i].lateralRaise;
      w.shoulderPress += wMenus[i].shoulderPress;
      w.bentoverLateral += wMenus[i].bentoverLateral;
      w.dumbellPullover += wMenus[i].dumbellPullover;

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
