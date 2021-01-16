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
    int[] fullBady = new int[SIZE];

    int count = 0;

    // 운동당일 날짜기록
    System.out.print("[날짜입력]> ");
    today[count] = Date.valueOf(scanner.nextLine());

    // 명령어입력
    while(true) {
      System.out.print("명령> ");
      String command = scanner.nextLine();
      if (command.equalsIgnoreCase("/today/add")) {
        // 운동기록 입력
        loop:
          while (true) {
            System.out.println("1. 상체");
            System.out.println("2. 하체");
            System.out.println("3. 팔");
            System.out.println("4. 유산소");
            System.out.print("[부위 선택]> ");
            int choice = scanner.nextInt();

            if (choice == 1) {
              System.out.println("1) 가슴부");
              System.out.println("2) 등");
              System.out.println("3) 복부");
              System.out.print("[부위선택]> ");
              choice = scanner.nextInt();
              switch (choice) {
                case 1:
                  System.out.print("푸쉬업: ");
                  pushUp[count] = scanner.nextInt();
                  System.out.print("딥스&스윙: ");
                  dipping[count] = scanner.nextInt();
                  break;
                case 2:
                  System.out.print("풀업: ");
                  chinning[count] = scanner.nextInt();
                  break;
                case 3:
                  System.out.print("행잉-레그: ");
                  hLegRaise[count] = scanner.nextInt();
              } // 가슴부위

            } else if (choice == 2) {
              System.out.print("스쿼트: ");
              squat[count] = scanner.nextInt();
              System.out.print("런지: ");
              lunge[count] = scanner.nextInt();
              // 하체부위
            } else if (choice == 3) {
              System.out.println("1) 이두");
              System.out.println("2) 삼두");
              System.out.println("3) 어깨");
              System.out.print("[선택]> ");
              choice = scanner.nextInt();
              switch (choice) {
                case 1: 
                  System.out.print("[갯수입력]> ");
                  biceps[count] = scanner.nextInt();
                  break;
                case 2: 
                  System.out.print("[갯수입력]> ");
                  triceps[count] = scanner.nextInt();
                  break;
                case 3:
                  System.out.print("[갯수입력]> ");
                  shoulder[count] = scanner.nextInt();
                  break;
              } // 팔부위

            } else if (choice == 4) {
              System.out.println("1) 러닝");
              System.out.println("2) 등산");
              System.out.println("3) 전신운동");
              System.out.print("[선택]> ");
              choice = scanner.nextInt();
              switch (choice) {
                case 1: 
                  System.out.print("[거리입력]> ");
                  running[count] = scanner.nextDouble();
                  break;
                case 2:
                  System.out.print("[시간입력(분)]> ");
                  hiking[count] = scanner.nextInt();
                  break;
                case 3:
                  System.out.print("[갯수입력]> ");
                  fullBady[count] = scanner.nextInt();
                  break;
              }
            } // 유산소
            count++;
            System.out.print("계속 입력하시겠습니까?(y/N) ");
            scanner.nextLine();
            String str = scanner.nextLine();
            if (!str.equalsIgnoreCase("y")) {
              break; // 입력반복 결정
            }
          }
      } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
        System.out.println("수고하셨습니다.");
        break;

      } else {
        System.out.println("잘못된 명렁어 입니다.");
        System.out.print("명령> ");
        command = scanner.nextLine();
      }
      System.out.println();
    }

  }
}
