package com.mypr.pms;

import java.sql.Date;

public class MenuHandler {

  static class Work{
    Date today;
    int pushUp;
    int dipping;
    int chinning;
    int squat;
    int lunge;
    int biceps;
    int triceps;
    int shoulder;
    int hLegRaise;
    int running;
    int hiking;
    int rope;
  }

  static final int SIZE = 100;
  static Work[] works = new Work[SIZE];
  static int count = 0;
  static Work w = new Work();

  static void Menu() {
    loop:
      while(true) {
        switch(First()) {
          case 1:
            UpperBady();
            Returns();
            break;
          case 2:
            w.squat = Prompt.inputInt("스쿼트 > ");
            w.lunge= Prompt.inputInt("런지 > ");
            Returns();
            break;
          case 3:
            w.running = Prompt.inputInt("러 닝(km) > ");
            w.hiking = Prompt.inputInt("등산(분) > ");
            w.rope =  Prompt.inputInt("배틀로프 > ");
            Returns();
            break;
          case 4:
            break;
          default :
            System.out.println("재입력 바랍니다.");
            continue loop;
        }

        break;
      }
  }

  static void Returns() {
    String str = Prompt.inputString("추가입력하시겠습니까? (y/N)>");
    if(str.equalsIgnoreCase("y")) {
      Menu();
    } else if (str.equalsIgnoreCase("n")) {
      Day();
    }
  }

  static void Day() {
    System.out.println("==============================");
    w.today = Prompt.inputDay("날짜입력 > ");
  }

  static int First() {
    int i = Prompt.inputInt("==============================\n"
        + "1.상체\n2.하체\n3.유산소\n4.뒤로가기\n> ");
    return i;
  }

  static void UpperBady() {
    loop:
      while(true) {
        int i = Prompt.inputInt("1.전면\n2.후면\n3.팔\n4.복부\n> ");
        switch(i) {
          case 1:
            w.pushUp = Prompt.inputInt("푸쉬업 > ");
            w.dipping = Prompt.inputInt("딥스 > ");
            break;
          case 2:
            w.chinning = Prompt.inputInt("풀업 > ");
            break;
          case 3:
            w.biceps = Prompt.inputInt("이두 > ");
            w.triceps = Prompt.inputInt("삼두 > ");
            w.shoulder = Prompt.inputInt("어깨 > ");
            break;
          case 4:
            w.hLegRaise = Prompt.inputInt("복부 > ");
            break;
          default :
            System.out.println("재입력 바랍니다.");
            continue loop;
        }
        break;
      }
  }

}


