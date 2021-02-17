package com.mypr.pms.handler;

import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import com.mypr.pms.domain.CalisthenicsMenu;
import com.mypr.pms.domain.CalisthenicsTotal;
import com.mypr.util.Prompt;

public class CalisthenicsMenuHandler {

  private LinkedList<CalisthenicsMenu> calisList = new LinkedList<>();
  private int rCount = 0;
  private int count = 0; 

  public void calisWorkMenu() {
    CalisthenicsMenu c = new CalisthenicsMenu();
    System.out.printf("\n현재까지 진행한 회차는(%d)회 입니다.", this.count);
    c.setNums(Prompt.inputInt("\n회차를 입력해주세요 : "));
    loop:
      while(true) {
        int i = Prompt.inputInt("\n"
            + "1.상체\n2.하체\n3.유산소\n4.뒤로가기\n> ");
        switch(i) {
          case 1:
            int i2 = Prompt.inputInt("\n1.전면\n2.후면\n3.복부\n4.뒤로가기\n> ");
            switch(i2) {
              case 1:
                c.setPushUp(Prompt.inputInt("푸쉬업 > "));
                c.setDipping(Prompt.inputInt("딥스 > "));
                break;
              case 2:
                c.setChinning(Prompt.inputInt("풀업 > "));
                break;
              case 3:
                c.sethLegRaise(Prompt.inputInt("복부 > "));
                break;
              case 4:
                continue loop;
            }
            break;
          case 2:
            c.setSquat(Prompt.inputInt("스쿼트 > "));
            c.setLunge(Prompt.inputInt("런지 > "));
            break;
          case 3:
            c.setRunning(Prompt.inputInt("러 닝(km) > "));
            if (c.getRunning() >=10 ) {
              c.setMarathonName(Prompt.inputString("대회 이름 > "));
              if(c.getMarathonName() == "") {
                String practice = "연습";
                c.setMarathonName(practice);
              }
            }
            c.setHiking(Prompt.inputInt("등산(분) > "));
            c.setRope(Prompt.inputInt("배틀로프 > "));
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
        c.setDate(new Date(System.currentTimeMillis()));
        break;
      }
    if (c.getRunning() >= 10) {
      rCount += 1;
    }
    count++;
    calisList.add(c);
    massage("기록이 등록되었습니다.");
  }

  public void calisRecodeList() throws CloneNotSupportedException{
    System.out.println();
    CalisthenicsMenu[] calisMenu = calisList.toArray(new CalisthenicsMenu[count]);
    if(calisMenu.length == 0) {
      System.out.println("\n입력된 정보가 없습니다.\n");
      return;
    }  
    for(CalisthenicsMenu c : calisMenu) {
      System.out.printf("[%d회차. %s]\n", c.getNums(), c.getDate());
    }
    cTodayRecode();
  }

  //    Iterator<CalisthenicsMenu> iterator = calisList.iterator();
  //
  //    while (iterator.hasNext()) {
  //      CalisthenicsMenu c = iterator.next();
  //      System.out.printf("[%d회차. %s]\n", c.getNums(), c.getDate());
  //    }
  //    todayRecode();
  //  }

  void cTodayRecode() {
    int no = Prompt.inputInt("> ");
    CalisthenicsMenu c1 = findByNo(no);
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
      System.out.println("-----[유산소]-----");
      recodeOutput("러     닝: %dKm\n", c1.getRunning());
      recodeOutput("등     산: %d분\n", c1.getHiking());

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
              rCount += 1;
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
      massage("기록을 변경하였습니다.");
    } else {
      massage("기록변경을 취소하였습니다.");
    }
  }

  public void delete(int number) {
    CalisthenicsMenu c = findByNo(number);
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    if (input.equalsIgnoreCase("y")) {

      int index = number + 1;
      c = findByNo(index);
      while (c != null) {
        c = findByNo(index);
        c.setNums(c.getNums() - 1);
        index++;
      }

      calisList.remove(c);
      massage("기록을 삭제하였습니다.");
    } else {
      massage("기록삭제를 취소하였습니다.");
    }
  }

  public void calisTotal() {
    CalisthenicsTotal t = new CalisthenicsTotal();
    CalisthenicsMenu[] calisMenu = calisList.toArray(new CalisthenicsMenu[count]);
    if (calisMenu.length == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    for(CalisthenicsMenu c : calisMenu) {
      t.setPushUp(t.getPushUp() + c.getPushUp());
      t.setDipping(t.getDipping() + c.getDipping());
      t.setChinning(t.getChinning() + c.getChinning());
      t.sethLegRaise(t.gethLegRaise() + c.gethLegRaise());
      t.setSquat(t.getSquat() + c.getSquat());
      t.setLunge(t.getLunge() + c.getLunge());
      t.setRunning(t.getRunning() + c.getRunning());
      t.setHiking(t.getHiking() + c.getHiking());
      t.setRope(t.getRope() + c.getRope());
    }
    System.out.printf("\n[운동횟수:%d회]\n", count);
    //   System.out.printf("[마라톤횟수:%d회]\n", calisList.rCount);
    System.out.println("-----[상  체]-----");
    System.out.printf("푸 쉬 업 : %d회\n", t.getPushUp());
    System.out.printf("딥스&스윙: %d회\n", t.getDipping());
    System.out.printf("풀     업: %d회\n", t.getChinning());
    System.out.printf("행잉-레그: %d회\n", t.gethLegRaise());
    System.out.println("-----[하  체]-----");
    System.out.printf("스 쿼 트 : %d회\n", t.getSquat());
    System.out.printf("런     지: %d회\n", t.getLunge());
    System.out.println("-----[유산소]-----");
    System.out.printf("러     닝: %dkm\n", t.getRunning());
    System.out.printf("등     산: %d분\n", t.getHiking());
    System.out.printf("배틀 로프: %d회\n", t.getRope());

  }

  public void marathonRecode() {
    if (count == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
    } else {
      Iterator<CalisthenicsMenu> iterator = calisList.iterator();
      System.out.printf("\n마라톤 회차: %d회\n", rCount);
      while (iterator.hasNext()) {
        CalisthenicsMenu c = iterator.next();
        if (c.getRunning() >= 10) {
          System.out.printf("[%d회차, %s]\n", c.getNums(), c.getDate());
        }

      }

      int no = Prompt.inputInt("입력> ");
      CalisthenicsMenu m = findByNo(no);
      if (no == m.getNums()) {
        System.out.printf("\n마라톤 완주거리: %d Km\n", m.getRunning());
        System.out.printf(String.format("마라톤 완주일자: %s\n", m.getDate()));
        System.out.printf("마라톤 대회이름: %s\n", m.getMarathonName());
        System.out.println("------------------------------");
      }
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
    CalisthenicsMenu[] list = calisList.toArray(new CalisthenicsMenu[count]);
    for (CalisthenicsMenu b : list) {
      if (b.getNums() == calisNo) {
        return b;
      }
    }
    return null;
  }


}

