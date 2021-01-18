package com.mypr.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  static final int SIZE = 100;
  static Scanner scanner = new Scanner(System.in);
  static Date[] today = new Date[SIZE];
  static int[] pushUp = new int[SIZE];
  static int[] dipping = new int[SIZE];
  static int[] chinning = new int[SIZE];
  static int[] hLegRaise = new int[SIZE];
  static int[] biceps = new int[SIZE];
  static int[] triceps = new int[SIZE];
  static int[] shoulder = new int[SIZE];
  static int[] squat = new int[SIZE];
  static int[] lunge = new int[SIZE];
  static int[] running = new int[SIZE];
  static int[] hiking = new int[SIZE];
  static int[] rope = new int[SIZE];

  static int count = 0;


  public static void main(String[] args) {

    loop1:
      while (true) {
        choiceMenu("=========================\n", "/add 추가하기"
            , "\n/recode 일일기록", "\n/total 누적기록\n");
        choiceMenu("=========================\n", "명령어> ");    // 명령어입력
        String command = scString();

        if (command.equalsIgnoreCase("/add")) {
          loop2:
            while (true) {

              choiceMenu("[날짜입력 yyyy-m-d]", "\n> ");
              today[count] = Date.valueOf(scString());

              loop3:
                while (true) {
                  choiceMenu("=========================\n", "[부위선택]\n"
                      , "1.상체\n", "2.하체\n", "3.유산소\n", "4.뒤로가기\n", "[선택]> ");
                  int r = scanner.nextInt();

                  if (r == 1) {
                    choiceMenu("=========================\n"
                        , "1.전면\n", "2.후면\n", "3.팔\n", "[선택]> ");
                    int s = scanner.nextInt();

                    if (s == 1) {
                      choiceMenu("=========================\n", "푸쉬업> ");
                      pushUp[count] = scanner.nextInt();

                      choiceMenu("딥스&스윙> ");
                      dipping[count] = scanner.nextInt();

                      choiceMenu("복부> ");
                      hLegRaise[count] = scanner.nextInt();

                      choiceMenu("추가입력 하시겠습니까?(y/N)> ");
                      scString();
                      String choice = scanner.nextLine();
                      switch (choice.toLowerCase()) {
                        case "y": continue loop3;

                        case "n":
                          count++;
                          break loop2;
                      }

                    } else if (s == 2) {
                      choiceMenu("=========================\n", "풀업> ");
                      chinning[count] = scanner.nextInt();

                      choiceMenu("추가입력 하시겠습니까?(y/N)> ");
                      scString();
                      String choice = scanner.nextLine();
                      switch (choice.toLowerCase()) {
                        case "y": continue loop3;

                        case "n":
                          count++;
                          break loop2;
                      }

                    } else if (s == 3) {
                      choiceMenu("=========================\n", "이두> ");
                      biceps[count] = scanner.nextInt();

                      choiceMenu("삼두> ");
                      triceps[count] = scanner.nextInt();

                      choiceMenu("어깨> ");
                      shoulder[count] = scanner.nextInt();

                      choiceMenu("추가입력 하시겠습니까?(y/N)> ");
                      scString();
                      String choice = scanner.nextLine();
                      switch (choice.toLowerCase()) {
                        case "y": continue loop3;

                        case "n":
                          count++;
                          break loop2;
                      }
                    }

                  } else if (r == 2) {
                    choiceMenu("=========================\n", "스쿼트> ");
                    squat[count] = scanner.nextInt();

                    choiceMenu("런지> ");
                    lunge[count] = scanner.nextInt();

                    choiceMenu("추가입력 하시겠습니까?(y/N)> ");
                    scString();
                    String choice = scanner.nextLine();
                    switch (choice.toLowerCase()) {
                      case "y": continue loop3;

                      case "n":
                        count++;
                        break loop2;
                    }

                  } else if (r == 3) {
                    choiceMenu("=========================\n", "러닝거리> ");
                    running[count] = scanner.nextInt();

                    choiceMenu("등산시간> ");
                    hiking[count] = scanner.nextInt();

                    choiceMenu("로프횟수> ");
                    rope[count] = scanner.nextInt();

                    choiceMenu("추가입력 하시겠습니까?(y/N)> ");
                    scString();
                    String choice = scanner.nextLine();
                    switch (choice.toLowerCase()) {
                      case "y": continue loop3;

                      case "n":
                        count++;
                        break loop2;
                    }

                  } else if (r == 4) {
                    scString();
                    break loop2;
                  }
                }
            }
        } else if (command.equalsIgnoreCase("/recode")) {
          for (int i = 0; i < count; i++) {
            choiceMenu("=========================\n");
            System.out.printf("[%d회차]: %s\n", i+1,  today[i]);

            choiceMenu("-----[상  체]-----\n");
            recoding("푸 쉬 업 ", "회", pushUp[i]);
            recoding("딥스&스윙", "회", dipping[i]);
            recoding("풀     업", "회", chinning[i]);
            recoding("행잉-레그", "회", hLegRaise[i]);

            choiceMenu("-----[하  체]-----\n");
            recoding("스 쿼 트 ", "회", squat[i]);
            recoding("런     지", "회", lunge[i]);

            choiceMenu("-----[  팔  ]-----\n");
            recoding("이     두", "회", biceps[i]);
            recoding("삼     두", "회", triceps[i]);
            recoding("어     깨", "회", shoulder[i]);

            choiceMenu("-----[유산소]-----\n");
            recoding("러     닝", "Km", running[i]);
            recoding("등     산", "분", hiking[i]);
            recoding("배틀 로프", "회", rope[i]);
          }


        } else if (command.equalsIgnoreCase("/total")) {

          choiceMenu("=========================\n");
          System.out.printf("[총 누적수] %d회\n", count);
          choiceMenu("-----[상  체]-----\n");
          sumTotal("푸 쉬 업 ", "회", pushUp);
          sumTotal("딥스&스윙", "회", dipping);
          sumTotal("풀     업", "회", chinning);
          sumTotal("행잉-레그", "회", hLegRaise);
          choiceMenu("-----[하  체]-----\n");
          sumTotal("스 쿼 트 ", "회", squat);
          sumTotal("런     지", "회", lunge);
          choiceMenu("-----[  팔  ]-----\n");
          sumTotal("이     두", "회", biceps);
          sumTotal("삼     두", "회", triceps);
          sumTotal("어     깨", "회", shoulder);
          choiceMenu("-----[유산소]-----\n");
          sumTotal("러     닝", "Km", running);
          sumTotal("등     산", "분", hiking);
          sumTotal("배틀 로프", "회", rope);

        } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
          break loop1;

        } else {
          choiceMenu("재입력 바랍니다.\n");
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

  static void recoding(String bady, String ea, int badyA) {
    if(badyA > 0) {
      System.out.printf("%s: %d%s\n", bady, badyA, ea);
    }
  }

  static void sumTotal(String bady, String ea, int sbady[]) {
    int sum = 0;
    for (int i = 0; i < count; i++) {
      sum += sbady[i];
    }
    recoding(bady, ea, sum);
  }

}

