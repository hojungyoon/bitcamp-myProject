package com.mypr.pms.handler;

import java.sql.Date;
import com.mypr.pms.domain.CalisthenicsMenu;
import com.mypr.pms.domain.CalisthenicsTotal;
import com.mypr.util.List;
import com.mypr.util.Prompt;

public class CalisthenicsMenuHandler {

  private List calisList = new List();
  private int cCount = 0;

  public void calisWorkMenu() {
    CalisthenicsMenu c1 = new CalisthenicsMenu();
    System.out.printf("\n현재까지 진행한 회차는(%d)회 입니다.", calisList.count);
    c1.setNums(Prompt.inputInt("\n회차 > "));
    loop:
      while(true) {
        int i = Prompt.inputInt("\n"
            + "1.상체\n2.하체\n3.유산소\n4.뒤로가기\n> ");
        switch(i) {
          case 1:
            loop1:
              while(true) {
                int i2 = Prompt.inputInt("\n1.전면\n2.후면\n3.팔\n4.복부\n5.뒤로가기\n> ");
                switch(i2) {
                  case 1:
                    c1.setPushUp(Prompt.inputInt("푸쉬업 > "));
                    c1.setDipping(Prompt.inputInt("딥스 > "));
                    break;
                  case 2:
                    c1.setChinning(Prompt.inputInt("풀업 > "));
                    break;
                  case 3:
                    c1.setBiceps(Prompt.inputInt("이두 > "));
                    c1.setTriceps(Prompt.inputInt("삼두 > "));
                    break;
                  case 4:
                    c1.sethLegRaise(Prompt.inputInt("복부 > "));
                    break;
                  case 5:
                    continue loop;
                  default :
                    massage("재입력바랍니다.");
                    continue loop1;
                }
                break;
              }
            break;
          case 2:
            c1.setSquat(Prompt.inputInt("스쿼트 > "));
            c1.setLunge(Prompt.inputInt("런지 > "));
            break;
          case 3:
            c1.setRunning(Prompt.inputInt("러 닝(km) > "));
            if (c1.getRunning() >=10 ) {
              calisList.rCount++;
              c1.setMarathonName(Prompt.inputString("대회 이름 > "));
              if(c1.getMarathonName() == "") {
                String practice = "연습";
                c1.setMarathonName(practice);
              }
            }
            c1.setHiking(Prompt.inputInt("등산(분) > "));
            c1.setRope(Prompt.inputInt("배틀로프 > "));
            break;
          case 4:
            massage("입력을 취소하였습니다.");
            return;
          default :
            massage("재입력 바랍니다.");
            continue loop;
        }
        if(reInput()) {
          continue loop;
        }
        c1.setDate(new Date(System.currentTimeMillis()));
        break;
      }
    calisList.add(c1);
    massage("기록이 등록되었습니다.");
  }

  public void calisRecodeList() {
    System.out.println();
    Object[] calisMenu = calisList.toArray();
    if (calisMenu != null) {
      for(Object list : calisMenu) {
        CalisthenicsMenu c = (CalisthenicsMenu) list;
        System.out.printf("[%d회차. %s]\n", c.getNums(), c.getDate());
      }
      todayRecode();
    } else {
      massage("입력된 정보가 없습니다.");
      return;
    }
  }

  void todayRecode() {
    while(true) {
      int no = Prompt.inputInt("> ");
      CalisthenicsMenu c1 = findByNo(no);
      if (no == c1.getNums()) {
        System.out.printf("\n[%d회차]: %s\n", c1.getNums(), c1.getNums());
        System.out.println("-----[상  체]-----");
        recodeOutput("푸 쉬 업 : %d회\n", c1.getPushUp());
        recodeOutput("딥스&스윙: %d회\n", c1.getDipping());
        recodeOutput("풀     업: %d회\n", c1.getChinning());
        recodeOutput("행잉-레그: %d회\n", c1.gethLegRaise());
        System.out.println("-----[하  체]-----");
        recodeOutput("스 쿼 트 : %d회\n", c1.getSquat());
        recodeOutput("런     지: %d회\n", c1.getLunge());
        System.out.println("-----[  팔  ]-----");
        recodeOutput("이     두: %d회\n", c1.getBiceps());
        recodeOutput("삼     두: %d회\n", c1.getTriceps());
        System.out.println("-----[유산소]-----");
        recodeOutput("러     닝: %dKm\n", c1.getRunning());
        recodeOutput("등     산: %d분\n", c1.getHiking());
        while(true) {
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
            default :
              System.out.printf("\n재입력 바랍니다.\n");
              continue;
          }
          break;
        }

      } else {
        System.out.println("다시입력 해주세요.");
        continue;
      }
      break;
    }
  }

  public void update(int number) {
    CalisthenicsMenu c = findByNo(number);
    if (c == null) {
      massage("입력된 정보가 없습니다.");
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
          + "\n7. 이두"
          + "\n8. 삼두"
          + "\n9. 러닝"
          + "\n10. 등산"
          + "\n11. 배틀로프"
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
          c.setBiceps(Prompt.inputInt("이두> "));
          break;
        case 8:
          c.setTriceps(Prompt.inputInt("삼두> "));
          break;
        case 9:
          c.setRunning(Prompt.inputInt("러닝> "));
          if (c.getRunning() >= 10) {
            c.setMarathonName(Prompt.inputString("대회 이름 > "));
            if(c.getMarathonName() == "") {
              String practice = "연습";
              c.setMarathonName(practice);
            }
          }
          break;
        case 10:
          c.setHiking(Prompt.inputInt("등산> "));
          break;
        case 11:
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
      massage("기록을 변경하였습니다.");
    } else {
      massage("기록변경을 취소하였습니다.");
    }
  }

  public void delete(int number) {
    CalisthenicsMenu c = findByNo(number);
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    //    Object[] calisMenu = calisList.toArray();
    //    for(Object list : calisMenu) {
    //      if (c.getNums() < calisList.count) {
    //        c1.setNums(c1.getNums()-1);
    //      }
    //      CalisthenicsMenu c1 = (CalisthenicsMenu) list;
    //    }

    if (input.equalsIgnoreCase("y")) {
      calisList.delete(c);


      int index = number + 1;

      c = findByNo(index);

      while (c != null) {
        c = findByNo(index);
        c.setNums(c.getNums() - 1);
        index++;
      }
      massage("기록을 삭제하였습니다.");
    } else {
      massage("기록삭제를 취소하였습니다.");
    }
  }


  private int a, b, c, d, e, f, g, h, i, j, k;


  public void calisTotal() {
    CalisthenicsTotal t = new CalisthenicsTotal();
    Object[] calisMenu = calisList.toArray();
    for(Object list : calisMenu) {
      CalisthenicsMenu c = (CalisthenicsMenu) list;
      if (c == null) {
        massage("아직 입력된 값이 없습니다.");
      } else {
        t.setPushUp(a += c.getPushUp());
        t.setDipping(b += c.getDipping());
        t.setChinning(this.c += c.getChinning());
        t.sethLegRaise(d += c.gethLegRaise());
        t.setSquat(e += c.getSquat());
        t.setLunge(f += c.getLunge());
        t.setBiceps(g += c.getBiceps());
        t.setTriceps(h += c.getTriceps());
        t.setRunning(i += c.getRunning());
        t.setHiking(j += c.getHiking());
        t.setRope(k += c.getRope());
      }
    }
    System.out.printf("\n[운동횟수:%d회]\n", calisList.count);
    //   System.out.printf("[마라톤횟수:%d회]\n", calisList.rCount);
    System.out.println("-----[상  체]-----");
    System.out.printf("푸 쉬 업 : %d회\n", t.getPushUp());
    System.out.printf("딥스&스윙: %d회\n", t.getDipping());
    System.out.printf("풀     업: %d회\n", t.getChinning());
    System.out.printf("행잉-레그: %d회\n", t.gethLegRaise());
    System.out.println("-----[하  체]-----");
    System.out.printf("스 쿼 트 : %d회\n", t.getSquat());
    System.out.printf("런     지: %d회\n", t.getLunge());
    System.out.println("-----[  팔  ]-----");
    System.out.printf("이     두: %d회\n", t.getBiceps());
    System.out.printf("삼     두: %d회\n", t.getTriceps());
    System.out.println("-----[유산소]-----");
    System.out.printf("러     닝: %dkm\n", t.getRunning());
    System.out.printf("등     산: %d분\n", t.getHiking());
    System.out.printf("배틀 로프: %d회\n", t.getRope());

  }


  public void marathonRecode() {
    Object[] calisMenu = calisList.toArray();
    for(Object list : calisMenu) {
      CalisthenicsMenu c = (CalisthenicsMenu)list;
      if (c == null) {
        massage("아직 마라톤을 진행하지 않았습니다.");
        return;
      } else {
        if (c.getRunning() >= 10) {
          System.out.printf("[%d회차, %s]\n", c.getNums(), c.getDate());
        }
      }
    }
    int no = Prompt.inputInt("입력> ");
    CalisthenicsMenu m = findByNo(no);
    if (no == m.getNums()) {
      System.out.printf("\n마라톤 회차: %d회\n", marathonCount(m.getRunning()));
      System.out.printf("\n마라톤 완주거리: %d Km\n", m.getRunning());
      System.out.printf(String.format("마라톤 완주일자: %s\n", m.getDate()));
      System.out.printf("마라톤 대회이름: %s\n", m.getMarathonName());
      System.out.println("------------------------------");
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
        System.out.printf("재입력 바랍니다.\n\n");
        continue;
      }
    }
  }

  private void recodeOutput(String work, int totals) {
    if (totals > 0) {
      System.out.printf(work, totals);
    }
  }

  private CalisthenicsMenu findByNo(int calisNo) {
    Object[] list = calisList.toArray();
    for (Object obj : list) {
      CalisthenicsMenu b = (CalisthenicsMenu) obj;
      if (b.getNums() == calisNo) {
        return b;
      }
    }
    return null;
  }

  private int marathonCount(int num) {
    Object[] calisMenu = calisList.toArray();
    for(Object list : calisMenu) {
      if (num >= 10) {
        CalisthenicsTotal t = new CalisthenicsTotal();
        int m1 = 0;
        t.setRunCount(m1 += 1);
        return t.getRunCount();
      }
    }
    return 0;
  }

}

