package com.mypr.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {

    final int SIZE = 100;
    Scanner scanner = new Scanner(System.in);

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

    double[] running = new double[SIZE];
    int[] hiking = new int[SIZE];
    int[] rope = new int[SIZE];

    int count = 0;

    loop1:
      while (true) {
        System.out.print("명령어> ");    // 명령어입력
        String command = scanner.nextLine();


        loop2:
          while (true) {
            if (command.equalsIgnoreCase("/today/add")) {
              System.out.print("[날짜입력]> ");
              today[count] = Date.valueOf(scanner.nextLine());

              System.out.println("[운동부위 선택]");
              System.out.println("1. 상체");
              System.out.println("2. 하체");
              System.out.println("3. 유산소");
              System.out.print("선택> ");
              int choice = scanner.nextInt();

              if (choice == 1) {
                System.out.println("1. 전면");
                System.out.println("2. 후면");
                System.out.println("3. 팔");
                System.out.print("선택> ");
                choice = scanner.nextInt();
                if (choice == 1) {
                  System.out.print("푸쉬업> ");
                  pushUp[count] = scanner.nextInt();

                  System.out.print("딥스&스윙> ");
                  dipping[count] = scanner.nextInt();

                  System.out.print("복부> ");
                  hLegRaise[count] = scanner.nextInt();
                  scanner.nextLine();

                  System.out.print("추가입력? (y/N)> ");
                  String command2 = scanner.nextLine();
                  if (command2.equalsIgnoreCase("y")) {
                    continue;
                  }
                  else if (command2.equalsIgnoreCase("n")) {
                    break loop2;
                  }

                } else if (choice == 2) {
                  System.out.print("풀업> ");
                  chinning[count] = scanner.nextInt();
                  scanner.nextLine();

                  System.out.print("추가입력? (y/N)> ");
                  String command2 = scanner.nextLine();
                  if (command2.equalsIgnoreCase("y")) {
                    continue;
                  }
                  else if (command2.equalsIgnoreCase("n")) {
                    break loop2;
                  }

                } else if (choice == 3) {
                  System.out.print("이두> ");
                  biceps[count] = scanner.nextInt();

                  System.out.print("삼두> ");
                  triceps[count] = scanner.nextInt();

                  System.out.print("어깨> ");
                  shoulder[count] = scanner.nextInt();
                  scanner.nextLine();

                  System.out.print("추가입력? (y/N)> ");
                  String command2 = scanner.nextLine();
                  if (command2.equalsIgnoreCase("y")) {
                    continue;
                  }
                  else if (command2.equalsIgnoreCase("n")) {
                    break loop2;
                  }
                }

              } else if (choice == 2) {
                System.out.print("스쿼트> ");
                squat[count] = scanner.nextInt();

                System.out.print("런지> ");
                lunge[count] = scanner.nextInt();
                scanner.nextLine();

                System.out.print("추가입력? (y/N)> ");
                String command2 = scanner.nextLine();
                if (command2.equalsIgnoreCase("y")) {
                  continue;
                }
                else if (command2.equalsIgnoreCase("n")) {
                  break loop2;
                }

              } else if (choice == 3) {
                System.out.print("러닝거리> ");
                running[count] = scanner.nextDouble();

                System.out.print("등산시간> ");
                hiking[count] = scanner.nextInt();

                System.out.print("로프횟수> ");
                rope[count] = scanner.nextInt();
                scanner.nextLine();

                System.out.print("추가입력? (y/N)> ");
                String command2 = scanner.nextLine();
                if (command2.equalsIgnoreCase("y")) {
                  continue;
                }
                else if (command2.equalsIgnoreCase("n")) {
                  break loop2;
                }
              }
              count++;
            } else if (command.equalsIgnoreCase("/recode/list")) {

              for (int i = 0; i < count; i++) {
                System.out.printf("[운동일자] %s\n", today[i]);

                System.out.println("[상체]");
                System.out.printf("[푸쉬업] %d회\n[딥스&스윙] %d회\n[풀업] %d회\n[복부] %d회\n"
                    + "[이두] %d회\n [삼두] %d회\n[어깨] %d회\n"
                    , pushUp[i], dipping[i], hLegRaise[i], chinning[i], biceps[i]
                        , triceps[i], shoulder[i]);

                System.out.println("[하체]");
                System.out.printf("[스쿼트] %d회\n[런지] %d회\n", squat[i], lunge[i]);

                System.out.println("[유산소]");
                System.out.printf("[러닝] %dkm\n[등산] %d분\n[로프] %d회\n"
                    , running[i], hiking[i], rope[i]);
              }
              break loop2;

            } else if (command.equalsIgnoreCase("/total/score")) {

            } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
              break loop1;
            } else {
              System.out.println("재입력 바랍니다.");
              continue loop1;
            }
          }
      }
    scanner.close();
  }
}

