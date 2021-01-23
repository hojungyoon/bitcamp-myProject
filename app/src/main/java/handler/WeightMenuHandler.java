package handler;

import com.mypr.pms.Prompt;
import com.mypr.pms.domain.WeightMenu;
import com.mypr.pms.domain.WeightTotal;

public class WeightMenuHandler {

  WeightMenu[] wMenus = new WeightMenu[CalisthenicsMenuHandler.SIZE];

  int count = 0;


  public void weightMenu() {
    WeightMenu w = new WeightMenu();

    loop:
      while(true) {
        int i = Prompt.inputInt("==============================\n"
            + "1.상체\n2.하체\n3.뒤로가기\n> ");
        switch(i) {
          case 1:
            w.dPress = Prompt.inputInt("덤벨프레스 > ");
            w.inDpress = Prompt.inputInt(" IN.프레스 > ");
            w.dFly = Prompt.inputInt("덤벨플라이 > ");
            w.inFly = Prompt.inputInt("IN.플라이 > ");
            break;
          case 2:
            w.bicepsCurl = Prompt.inputInt("이두덤벨컬 > ");
            w.tricepOver = Prompt.inputInt("오버헤드익스텐션 > ");
            break;
          case 3:
            w.lateralRaise = Prompt.inputInt("레터럴라이즈 > ");
            w.shoulderPress = Prompt.inputInt("숄더프레스 > ");
            w.bentoverLateral = Prompt.inputInt("벤트오버 > ");
            break;
          case 4:
            w.dumbellPullover = Prompt.inputInt("덤벨풀오버 > ");
          case 5:
            break;
          default :
            System.out.println("재입력 바랍니다.");
            continue loop;
        }
        if(reInput() == true) {
          continue loop;
        }
        System.out.println("==============================");
        w.today = Prompt.inputDay("날짜입력 > ");
        break;
      }
    this.wMenus[this.count++] = w;
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

  public void recode() {
    for (int i = 0; i < count; i++) {
      WeightMenu w = this.wMenus[i];
      System.out.printf("\n==============================\n");
      System.out.printf("[%d회차]: %s\n", i+1, w.today);
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

  public void total(WeightMenuHandler menuhandler) {
    WeightTotal w = new WeightTotal();

    int a = 0;
    for (; a < count; a++) {
      w.today = a+1;
      w.dPress += menuhandler.wMenus[a].dPress;
      w.inDpress+= menuhandler.wMenus[a].inDpress;
      w.dFly += menuhandler.wMenus[a].dFly;
      w.inFly += menuhandler.wMenus[a].inFly;
      w.bicepsCurl += menuhandler.wMenus[a].bicepsCurl;
      w.tricepOver += menuhandler.wMenus[a].tricepOver;
      w.lateralRaise += menuhandler.wMenus[a].lateralRaise;
      w.shoulderPress += menuhandler.wMenus[a].shoulderPress;
      w.bentoverLateral += menuhandler.wMenus[a].bentoverLateral;
      w.dumbellPullover += menuhandler.wMenus[a].dumbellPullover;

    }
    System.out.printf("==============================\n");
    System.out.printf("[운동횟수:%d회]\n", w.today);
    System.out.println("-----[가  슴]-----");
    System.out.printf("덤벨프레스 : %d회\n", w.dPress);
    System.out.printf("IN.프 레 스: %d회\n", w.inDpress);
    System.out.printf("덤벨플라이 : %d회\n", w.dFly);
    System.out.println("-----[  팔  ]-----");
    System.out.printf("이두 덤벨컬 : %d회\n", w.bicepsCurl);
    System.out.printf("오버헤드익스: %d회\n", w.tricepOver);
    System.out.println("-----[어  깨]-----");
    System.out.printf("레터럴라이즈: %d회\n", w.lateralRaise);
    System.out.printf("숄더 프레스 : %d회\n", w.shoulderPress);
    System.out.printf("벤 트 오 버 : %d회\n", w.bentoverLateral);
    System.out.println("-----[전  면]-----");
    System.out.printf("덤벨 풀오버 : %dKm\n", w.dumbellPullover);
    System.out.println("==============================");
  }

  public void recodeOutput(String work, int totals) {
    if(totals > 0) {
      System.out.printf(work, totals);
    }

  }


}

