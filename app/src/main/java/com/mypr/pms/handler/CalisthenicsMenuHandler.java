package com.mypr.pms.handler;

import java.sql.Date;
import com.mypr.pms.domain.CalisthenicsTotal;
import com.mypr.pms.domain.CalisthenicshMenu;
import com.mypr.util.Prompt;

public class CalisthenicsMenuHandler {

  Node first;
  Node last;
  int cCount = 0;

  public void calisWorkMenu() {
    CalisthenicshMenu c1 = new CalisthenicshMenu();
    Node cursor = first;
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
                    c1.pushUp = Prompt.inputInt("푸쉬업 > ");
                    c1.dipping = Prompt.inputInt("딥스 > ");
                    break;
                  case 2:
                    c1.chinning = Prompt.inputInt("풀업 > ");
                    break;
                  case 3:
                    c1.biceps = Prompt.inputInt("이두 > ");
                    c1.triceps = Prompt.inputInt("삼두 > ");
                    break;
                  case 4:
                    c1.hLegRaise = Prompt.inputInt("복부 > ");
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
            c1.squat = Prompt.inputInt("스쿼트 > ");
            c1.lunge= Prompt.inputInt("런지 > ");
            break;
          case 3:
            c1.running = Prompt.inputInt("러 닝(km) > ");
            if (c1.running >=10 ) {
              c1.marathonName = Prompt.inputString("대회 이름 > ");
              if(c1.marathonName == "") {
                String practice = "연습";
                c1.marathonName = practice;
              }
            }
            c1.hiking = Prompt.inputInt("등산(분) > ");
            c1.rope =  Prompt.inputInt("배틀로프 > ");
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

        c1.date = new Date(System.currentTimeMillis());
        break;
      }
    Node node = new Node(c1);
    if(last == null) {
      if(node.calisMenu.running >= 10) {
        node.calisMenu.runCount = 1;
      } else {
        node.calisMenu.runCount = 0;
      }
      first = node;
      last = node;

    } else {
      last.next = node;
      node.prev = last;
      last = node;
      node.calisMenu.runCount = node.prev.calisMenu.runCount;
      if(node.calisMenu.running >= 10) {
        node.calisMenu.runCount += 1;
      }
    }


    this.cCount++;
    node.calisMenu.nums = this.cCount;
    massage("기록이 등록되었습니다.");

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

  public void calisRecode() {
    Node cursor = first;
    if (cursor == null) {
      System.out.printf("입력된 정보가 없습니다.\n");
    } else {
      while(cursor != null) {
        CalisthenicshMenu c = cursor.calisMenu;
        System.out.printf("[%d회차. %s]\n", c.nums, c.date);
        cursor = cursor.next;
      }
      calisRecodeList();
    }
  }

  public void calisRecodeList() {
    while(true) {
      int no = Prompt.inputInt("> ");
      CalisthenicshMenu c = findByNo(no);
      if (no == c.nums) {
        System.out.printf("\n[%d회차]: %s\n", c.nums, c.date);
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
        System.out.println("-----[유산소]-----");
        recodeOutput("러     닝: %dKm\n", c.running);
        recodeOutput("등     산: %d분\n", c.hiking);
      } else {
        System.out.println("다시입력 해주세요.");
        continue;
      }
      break;
    }
  }

  public void calisTotal() {
    Node cursor = first;
    CalisthenicsTotal t = new CalisthenicsTotal();
    while(cursor != null) {
      t.pushUp += cursor.calisMenu.pushUp;
      t.dipping += cursor.calisMenu.dipping;
      t.chinning += cursor.calisMenu.chinning;
      t.hLegRaise += cursor.calisMenu.hLegRaise;
      t.squat += cursor.calisMenu.squat;
      t.lunge += cursor.calisMenu.lunge;
      t.biceps += cursor.calisMenu.biceps;
      t.triceps += cursor.calisMenu.triceps;
      t.running += cursor.calisMenu.running;
      t.hiking += cursor.calisMenu.hiking;
      t.rope += cursor.calisMenu.rope;
      cursor = cursor.next;
    }
    System.out.printf("\n[운동횟수:%d회]\n", last.calisMenu.nums);
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
    Node cursor = first;
    if (cursor == null) {
      massage("아직 마라톤을 진행하지 않았습니다.");
      return;
    } else {
      while(cursor != null) {
        CalisthenicshMenu m = cursor.calisMenu;
        if (m.running >= 10) {
          System.out.printf("[%d회차, %s]\n", m.nums, m.date);
        }
        cursor = cursor.next;
      }
      int no = Prompt.inputInt("입력> ");
      CalisthenicshMenu m = findByNo(no);
      if (no == m.nums) {
        System.out.printf("\n마라톤 회차: %d회\n", m.runCount);
        System.out.printf("\n마라톤 완주거리: %d Km\n", m.running);
        System.out.printf(String.format("마라톤 완주일자: %s\n", m.date));
        System.out.printf("마라톤 대회이름: %s\n", m.marathonName);
        System.out.println("------------------------------");
      }
    }
  }


  public void upAndDel() {
    Node cursor = first;
    if (cursor != null) {
      while (cursor != null) {
        CalisthenicshMenu c = cursor.calisMenu;
        System.out.printf("[%d회차. %s]\n", c.nums, c.date);
        cursor = cursor.next;
      }
    } else { 
      massage("입력된 정보가 없습니다.");
      return;
    }
    while(true) {
      int number2 = Prompt.inputInt("\n1.update\n2.Delete\n3.뒤로가기\n> ");
      switch(number2) {
        case 1:
          update();
          break;
        case 2:
          delete();
          break;
        case 3:
          break;
        default :
          System.out.printf("\n재입력 바랍니다.\n");
          continue;
      }
      break;
    }
  }

  public void update() {
    System.out.println("[수정할 게시물의 번호를 선택해주세요.]");
    int no = Prompt.inputInt("> ");

    CalisthenicshMenu c = findByNo(no);
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
          c.pushUp = Prompt.inputInt("푸쉬업> ");
          break;
        case 2:
          c.dipping = Prompt.inputInt("딥스&스윙> ");
          break;
        case 3:
          c.chinning = Prompt.inputInt("풀업> " );
          break;
        case 4:
          c.hLegRaise = Prompt.inputInt("행잉-레그> ");
          break;
        case 5:
          c.squat = Prompt.inputInt("스쿼트> ");
          break;
        case 6:
          c.lunge = Prompt.inputInt("런지> ");
          break;
        case 7:
          c.biceps = Prompt.inputInt("이두> ");
          break;
        case 8:
          c.triceps = Prompt.inputInt("삼두> ");
          break;
        case 9:
          c.running = Prompt.inputInt("러닝> ");
          if (c.running >= 10) {
            c.marathonName = Prompt.inputString("대회 이름 > ");
            if(c.marathonName == "") {
              String practice = "연습";
              c.marathonName = practice;
            }
          }
          break;
        case 10:
          c.hiking = Prompt.inputInt("등산> ");
          break;
        case 11:
          c.hiking = Prompt.inputInt("배틀로프> ");
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

  public void delete() {
    System.out.println("[기록을 삭제할 게시물의 번호를 입력해주세요.]");
    int no = Prompt.inputInt("> ");

    CalisthenicshMenu c = findByNo(no);
    if(c == null) {
      massage("해당 기록이 존재하지 않습니다.");

      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    if (input.equalsIgnoreCase("y")) {
      Node cursor = first;
      while(cursor != null) {

        cursor.next.calisMenu.nums -= 1;
        if(cursor.calisMenu.running >= 10) {
          cursor.next.calisMenu.runCount -= 1;
        }

        if(cursor.calisMenu == c) {
          if (first == last) {
            first = last = null;
            break;
          }
          if (cursor == first) {
            first = cursor.next;
            cursor.prev = null;

          } else {
            cursor.prev.next = cursor.next;
            if (cursor.prev != null) {
              cursor.next.prev = cursor.prev;
            }
          }
          if (cursor == last) {
            last = cursor.prev;
          }
          break;
        }
        cursor = cursor.next;
      }
      massage("기록을 삭제하였습니다.");
    } else {
      massage("기록삭제를 취소하였습니다.");
    }
  }

  CalisthenicshMenu findByNo(int calisNumber) {
    Node cursor = first;
    while (cursor != null) {
      CalisthenicshMenu c = cursor.calisMenu;
      if (c.nums == calisNumber) {
        return c;
      }
      cursor = cursor.next;
    }
    return null;
  }


  public static void massage(String massage) {
    System.out.printf("\n-------------------------------\n"
        + "%s"
        + "\n-------------------------------\n", massage);
  }

  static class Node {
    CalisthenicshMenu calisMenu;
    Node next;
    Node prev;

    Node(CalisthenicshMenu c) {
      this.calisMenu = c;
    }
  }


}

