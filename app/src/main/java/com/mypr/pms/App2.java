package com.mypr.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    final int SIZE = 100;


    Date[] today = new Date[SIZE];

    int[] pushUp = new int[SIZE];
    int[] dipping = new int[SIZE];
    int[] chinning = new int[SIZE];
    int[] hLegRaise = new int[SIZE];
    int[] biceps = new int[SIZE];
    int[] triceps = new int[SIZE];
    int[] shoulder = new int[SIZE];
    int[] squat = new int[SIZE];
    int[] lunge = new int[SIZE];
    int[] running = new int[SIZE];
    int[] hiking = new int[SIZE];
    int[] rope = new int[SIZE];

    int sDay = 0;
    int sPushUp = 0;
    int sDipping = 0;
    int sChinning = 0;
    int sSquat = 0;
    int sLunge = 0;
    int sBieps = 0;
    int sTriceps = 0;
    int sShoulder = 0;
    int sHLegRaise = 0;
    int sRunning = 0;
    int sHiking = 0;
    int sRope = 0;

    int count = 0;


    loop1:
      while (true) {
        System.out.print("명령어> ");    // 명령어입력
        String command = scString();

        if (command.equalsIgnoreCase("/today/add")) {
          loop2:
            while (true) {

              System.out.print("[날짜입력]> ");
              today[count] = Date.valueOf(scString());

              loop3:
                while (true) {
                  choiceMenu("\n[부위선택]\n", "1.상체\n", "2.하체\n", "3.유산소\n", "4.메인\n", "[선택]> ");
                  int r = scanner.nextInt();

                  if (r == 1) {
                    choiceMenu("\n1.전면\n", "2.후면\n", "3.팔\n", "[선택]> ");
                    int s = scanner.nextInt();

                    if (s == 1) {
                      choiceMenu("\n푸쉬업> ");
                      pushUp[count] = scanner.nextInt();;

                      choiceMenu("딥스&스윙> ");
                      dipping[count] = scanner.nextInt();;

                      choiceMenu("복부> ");
                      hLegRaise[count] = scanner.nextInt();;

                      continue loop3;

                    } else if (s == 2) {
                      choiceMenu("\n풀업> ");
                      chinning[count] = scanner.nextInt();;

                      continue loop3;

                    } else if (s == 3) {
                      choiceMenu("\n이두> ");
                      biceps[count] = scanner.nextInt();;

                      choiceMenu("삼두> ");
                      triceps[count] = scanner.nextInt();;

                      choiceMenu("어깨> ");
                      shoulder[count] = scanner.nextInt();;
                      scanner.nextLine();

                      continue loop3;

                    }

                  } else if (r == 2) {
                    choiceMenu("\n스쿼트> ");
                    squat[count] = scanner.nextInt();

                    choiceMenu("런지> ");
                    lunge[count] = scanner.nextInt();


                    continue loop3;

                  } else if (r == 3) {
                    choiceMenu("러닝거리> ");
                    running[count] = scanner.nextInt();

                    choiceMenu("등산시간> ");
                    hiking[count] = scanner.nextInt();

                    choiceMenu("로프횟수> ");
                    rope[count] = scanner.nextInt();

                    continue loop3;

                  } else if (r == 4) {
                    scString();
                    count++;
                    break loop2;
                  }
                }
            }
        } else if (command.equalsIgnoreCase("/recode/list")) {
          for (int i = 0; i < count; i++) {
            System.out.printf("[%d회차]: %s\n", i+1,  today[i]);

            System.out.println("-----[상  체]-----");
            if (pushUp[i] > 0) {
              System.out.printf("푸 쉬 업 : %d회\n", pushUp[i]);
            }
            if (dipping[i] > 0) {
              System.out.printf("딥스&스윙: %d회\n", dipping[i]);
            }
            if (chinning[i] > 0) {
              System.out.printf("풀     업: %d회\n", chinning[i]);
            }
            if (hLegRaise[i] > 0) {
              System.out.printf("행잉-레그: %d회\n", hLegRaise[i]);
            }
            System.out.println("-----[하  체]-----");
            if (squat[i] > 0) {
              System.out.printf("스 쿼 트 : %d회\n", squat[i]);
            }
            if (lunge[i] > 0) {
              System.out.printf("런     지: %d회\n", lunge[i]);
            }
            System.out.println("-----[  팔  ]-----");
            if (biceps[i] > 0) {
              System.out.printf("이     두: %d회\n", biceps[i]);
            }
            if (triceps[i] > 0) {
              System.out.printf("삼     두: %d회\n", triceps[i]);
            }
            if (shoulder[i] > 0) {
              System.out.printf("어     깨: %d회\n", shoulder[i]);
            }
            System.out.println("-----[유산소]-----");
            if (running[i] > 0) {
              System.out.printf("러     닝: %dkm\n", running[i]);
            }
            if (hiking[i] > 0) {
              System.out.printf("등     산: %d분\n", hiking[i]);
            }
            if (rope[i] > 0) {
              System.out.printf("배틀 로프: %d회\n", rope[i]);
            }
            System.out.println("-----------------------------");
          }

        } else if (command.equalsIgnoreCase("/total/score")) {
          for (int i = 0; i < count; i++) {
            sDay = i+1;
            sPushUp += pushUp[i];
            sDipping += dipping[i];
            sChinning += chinning[i];
            sSquat += squat[i];
            sLunge += lunge[i];
            sBieps += biceps[i];
            sTriceps += triceps[i];
            sShoulder += shoulder[i];
            sHLegRaise += hLegRaise[i];
            sRunning += running[i];
            sHiking += hiking[i];
            sRope += rope[i];
          }
          System.out.println("[총 누적수]");
          System.out.printf("[운동횟수:%d회]\n", sDay);
          System.out.println("-----[상  체]-----");
          System.out.printf("푸 쉬 업 : %d회\n", sPushUp);
          System.out.printf("딥스&스윙: %d회\n", sDipping);
          System.out.printf("풀     업: %d회\n", sChinning);
          System.out.printf("행잉-레그: %d회\n", sHLegRaise);
          System.out.println("-----[하  체]-----");
          System.out.printf("스 쿼 트 : %d회\n", sSquat);
          System.out.printf("런     지: %d회\n", sLunge);
          System.out.println("-----[  팔  ]-----");
          System.out.printf("이     두: %d회\n", sBieps);
          System.out.printf("삼     두: %d회\n", sTriceps);
          System.out.printf("어     깨: %d회\n", sShoulder);
          System.out.println("-----[유산소]-----");
          System.out.printf("러     닝: %dkm\n", sRunning);
          System.out.printf("등     산: %d분\n", sHiking);
          System.out.printf("배틀 로프: %d회\n", sRope);
          System.out.println("-----------------------------"); 

        } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
          break loop1;

        } else {
          System.out.println("재입력 바랍니다.");
          continue loop1;
        }

      }
    scanner.close();
    System.out.println();
  }


  static String scString() {
    return scanner.nextLine();
  }

  static int scInt() {
    return scanner.nextInt();
  }

  static void choiceMenu(String... a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
    }
  }

}

