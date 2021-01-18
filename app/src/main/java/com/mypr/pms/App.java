package com.mypr.pms;

import java.sql.Date;
import java.util.Scanner;


public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    //당일 운동횟수 데이터
    final int SIZE = 100;
    Date[] today = new Date[SIZE];
    int[] pushUp = new int[SIZE];
    int[] dipping = new int[SIZE];
    int[] chinning = new int[SIZE];
    int[] squat = new int[SIZE];
    int[] lunge = new int[SIZE];
    int[] biceps = new int[SIZE];
    int[] triceps = new int[SIZE];
    int[] shoulder = new int[SIZE];
    int[] hLegRaise = new int[SIZE];
    double[] running = new double[SIZE];
    int[] hiking = new int[SIZE];
    int[] rope = new int[SIZE];

    int count = 0;

    // 누적 횟수를 담을 데이터
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
    double sRunning = 0;
    int sHiking = 0;
    int sRope = 0;

    // 운동당일 날짜기록
    loop1:
      while (true) {
        System.out.print("명령어> ");    // 명령어입력
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("/today/add")) {

          System.out.print("[날짜입력]> ");
          today[count] = Date.valueOf(scanner.nextLine()); // 운동기록 입력

          System.out.print("푸 쉬 업 > ");
          pushUp[count] = scanner.nextInt();

          System.out.print("딥스/스윙> ");
          dipping[count] = scanner.nextInt();

          System.out.print("풀     업> ");
          chinning[count] = scanner.nextInt();

          System.out.print("스 쿼 트 > ");
          squat[count] = scanner.nextInt();

          System.out.print("런     지> ");
          lunge[count] = scanner.nextInt();

          System.out.print("이     두> ");
          biceps[count] = scanner.nextInt();

          System.out.print("삼     두> ");
          triceps[count] = scanner.nextInt();

          System.out.print("어     깨> ");
          shoulder[count] = scanner.nextInt();

          System.out.print("복     부> ");
          hLegRaise[count] = scanner.nextInt();

          System.out.print("러     닝> ");
          running[count] = scanner.nextDouble();

          System.out.print("하 이 킹 > ");
          hiking[count] = scanner.nextInt();

          System.out.print("배틀로프 > ");
          rope[count] = scanner.nextInt();

          scanner.nextLine();

          count++;


        } else if (command.equalsIgnoreCase("/recode/list")) {
          for (int i = 0; i < count; i++) {
            if (pushUp[i] > 0) {
              System.out.printf("[%d회차]: %s\n", i,  today[i]);
              System.out.println("-----[상  체]-----");
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
            if (squat[i] > 0) {
              System.out.println("-----[하  체]-----");
              System.out.printf("스 쿼 트 : %d회\n", squat[i]);
            }
            if (lunge[i] > 0) {
              System.out.printf("런     지: %d회\n", lunge[i]);
            }
            if (biceps[i] > 0) {
              System.out.println("-----[  팔  ]-----");
              System.out.printf("이     두: %d회\n", biceps[i]);
            }
            if (triceps[i] > 0) {
              System.out.printf("삼     두: %d회\n", triceps[i]);
            }
            if (shoulder[i] > 0) {
              System.out.printf("어     깨: %d회\n", shoulder[i]);
            }
            if (running[i] > 0) {
              System.out.println("-----[유산소]-----");
              System.out.printf("러     닝: %.2fkm\n", running[i]);
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
            sDay = i;
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
          System.out.printf("러     닝: %.2fkm\n", sRunning);
          System.out.printf("등     산: %d분\n", sHiking);
          System.out.printf("배틀 로프: %d회\n", sRope);
          System.out.println("-----------------------------"); 

        } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
          System.out.println("수고하셨습니다.");
          break;

        } else {
          System.out.println("잘못된 명령어 입니다.");
        }
        System.out.println();
      }
    scanner.close();
  }
}

