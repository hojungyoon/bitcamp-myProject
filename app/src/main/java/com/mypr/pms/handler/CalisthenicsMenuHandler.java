package com.mypr.pms.handler;

import com.mypr.pms.Prompt;
import com.mypr.pms.domain.CalisthenicsTotal;
import com.mypr.pms.domain.CalisthenicshMenu;
import sun.lwawt.macosx.CMenu;

public class CalisthenicsMenuHandler {
  static final int SIZE = 100;

  CalisthenicshMenu[] cMenus = new CalisthenicshMenu[SIZE];

  int cCount = 0;

  public void calisWorkMenu() {
    CalisthenicshMenu c1 = new CalisthenicshMenu();
    loop:
      while(true) {
        int i = Prompt.inputInt("\n"
            + "1.상체\n2.하체\n3.유산소\n4.뒤로가기\n> ");

        switch(i) {
          case 1:
            loop1:
              while(true) {
                int i2 = Prompt.inputInt("\n1.전면\n2.후면\n3.팔\n4.복부\n> ");
                switch(i2) {
                  case 1:
                    c1.pushUp = Prompt.inputInt("푸쉬업 > ");
                    c1.dipping = Prompt.inputInt("딥스 > ");
                    break;
                  case 2:
                    c1.chinning = Prompt.inputInt("풀업 > ");
                    break;
                  case 3:
                    c1.biceps = Prompt.inputInt("이두 > ");
                    c1.triceps = Prompt.inputInt("삼두 > ");
                    c1.shoulder = Prompt.inputInt("어깨 > ");
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
            c1.marathonName = Prompt.inputString("대회 이름 > ");
            c1.hiking = Prompt.inputInt("등산(분) > ");
            c1.rope =  Prompt.inputInt("배틀로프 > ");
            break;
          case 4:
            break loop;
          default :
            System.out.println("재입력 바랍니다.");
            continue loop;

        }
        if(reInput()) {
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
          System.out.printf("재입력 바랍니다.\n\n");
          continue;
        }
      }
  }

  int a = 0;

  public void calisRecode() {
    if (this.cMenus[0] == null) {
      System.out.printf("입력된 정보가 없습니다.\n\n");
    } else {
      for (int i = 0; i < this.cCount; i++) {
        CalisthenicshMenu c = this.cMenus[i];
        System.out.printf("[%d. %s]\n", i+1, c.day);
      }
      calisRecodeList();
    }
  }

  public void calisRecodeList() {
    int no = Prompt.inputInt("> ");
    for (int i = 0; i < this.cCount; i++) {
      CalisthenicshMenu c = this.cMenus[i];
      this.a = i + 1;
      if (no == i + 1) {
        System.out.printf("\n[%d회차]: %s\n", this.a, c.day);
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
      } 
    }
  }

  public void calisTotal() {
    CalisthenicsTotal t = new CalisthenicsTotal();
    for (int a = 0; a < this.cCount; a++) {
      CalisthenicshMenu ct = this.cMenus[a];
      t.day = a+1;
      t.pushUp += ct.pushUp;
      t.dipping += ct.dipping;
      t.chinning += ct.chinning;
      t.hLegRaise += ct.hLegRaise;
      t.squat += ct.squat;
      t.lunge += ct.lunge;
      t.biceps += ct.biceps;
      t.triceps += ct.triceps;
      t.shoulder += ct.shoulder;
      t.running += ct.running;
      t.hiking += ct.hiking;
      t.rope += ct.rope;

    }
    System.out.printf("\n[운동횟수:%d회]\n", t.day);
    System.out.println("-----[상  체]-----");
    System.out.printf("푸 쉬 업 : %d회\n", t.pushUp);
    System.out.printf("딥스&스윙: %d회\n", t.dipping);
    System.out.printf("풀     업: %d회\n", t.chinning);
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

  }

  public void recodeOutput(String work, int totals) {
    if (totals > 0) {
      System.out.printf(work, totals);
    }
  }

  public void marathonRecode() {
    for( int i = 0; i < this.cCount; i++) {
      CalisthenicshMenu m = this.cMenus[i];
      this.a = i + 1;
      if (m.running >= 10) {
        System.out.printf("[%d, %s]\n", this.a, m.day);
      }
    }
    marathonRecodeList();
  }

  public void marathonRecodeList() {
    int no = Prompt.inputInt("> ");
    for (int i = 0; i < this.cCount; i++) {
      CalisthenicshMenu m = this.cMenus[i];
      if (no == i + 1) {
        System.out.printf("\n마라톤 완주거리: %dKm\n", m.running);
        System.out.printf("마라톤 완주일자: %s\n", m.day);
        System.out.printf("마라톤 대회이름: %s\n", m.marathonName);
        System.out.println("------------------------------");
      } 
    }
  }

  public void update() {
    System.out.println("[기록변경]");
    if (this.cMenus[0] == null) {
      System.out.printf("입력된 정보가 없습니다.\n\n");
    } else {
      for (int i = 0; i < this.cCount; i++) {
        CalisthenicshMenu c = this.cMenus[i];
        a = i + 1;
        System.out.printf("[%d. %s]\n", a, c.day);
      }
      int number = Prompt.inputInt("> ");
      if(number == a) {
        System.out.printf("\n1.상체 전면\n2.상체 후면\n3.팔\n4.하체\n5.유산소\n");
        number = Prompt.inputInt("수정할 부분 >");
        switch(number) {
          case 1:
            int pushUp = Prompt.inputInt("%d => ", );

        }
      }
    }
  }

}