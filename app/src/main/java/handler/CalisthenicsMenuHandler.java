package handler;

import com.mypr.pms.Prompt;
import com.mypr.pms.domain.CalisthenicsTotal;
import com.mypr.pms.domain.CalisthenicshMenu;

public class CalisthenicsMenuHandler {
  static final int SIZE = 100;

  CalisthenicshMenu[] cMenus = new CalisthenicshMenu[SIZE];

  int count = 0;


  public void calisMenu() {
    CalisthenicshMenu c = new CalisthenicshMenu();

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
                    c.pushUp = Prompt.inputInt("푸쉬업 > ");
                    c.dipping = Prompt.inputInt("딥스 > ");
                    break;
                  case 2:
                    c.chinning = Prompt.inputInt("풀업 > ");
                    break;
                  case 3:
                    c.biceps = Prompt.inputInt("이두 > ");
                    c.triceps = Prompt.inputInt("삼두 > ");
                    c.shoulder = Prompt.inputInt("어깨 > ");
                    break;
                  case 4:
                    c.hLegRaise = Prompt.inputInt("복부 > ");
                    break;
                  default :
                    System.out.println("재입력 바랍니다.");
                    continue loop1;
                }
                break;
              }
            break;
          case 2:
            c.squat = Prompt.inputInt("스쿼트 > ");
            c.lunge= Prompt.inputInt("런지 > ");
            break;
          case 3:
            c.running = Prompt.inputInt("러 닝(km) > ");
            c.hiking = Prompt.inputInt("등산(분) > ");
            c.rope =  Prompt.inputInt("배틀로프 > ");
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
        System.out.println("==============================");
        c.today = Prompt.inputDay("날짜입력 > ");
        break;
      }
    this.cMenus[this.count++] = c;
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
      CalisthenicshMenu c = this.cMenus[i];
      System.out.printf("\n==============================\n");
      System.out.printf("[%d회차]: %s\n", i+1, c.today);
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

  public void total(CalisthenicsMenuHandler menuhandler) {
    CalisthenicsTotal t = new CalisthenicsTotal();

    int a = 0;
    for (; a < count; a++) {
      t.day = a+1;
      t.pushUp += menuhandler.cMenus[a].pushUp;
      t.dipping += menuhandler.cMenus[a].dipping;
      t.chinning += menuhandler.cMenus[a].chinning;
      t.hLegRaise += menuhandler.cMenus[a].hLegRaise;
      t.squat += menuhandler.cMenus[a].squat;
      t.lunge += menuhandler.cMenus[a].lunge;
      t.biceps += menuhandler.cMenus[a].biceps;
      t.triceps += menuhandler.cMenus[a].triceps;
      t.shoulder += menuhandler.cMenus[a].shoulder;
      t.running += menuhandler.cMenus[a].running;
      t.hiking += menuhandler.cMenus[a].hiking;
      t.rope += menuhandler.cMenus[a].rope;

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

  public void recodeOutput(String work, int totals) {
    if(totals > 0) {
      System.out.printf(work, totals);
    }

  }


}

