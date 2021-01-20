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


  static void Menu() {
    Work w = new Work();

    System.out.println("==============================");
    w.today = Prompt.inputDay("날짜입력 > ");
    w.pushUp = Prompt.inputInt("푸쉬업 > ");
    w.dipping = Prompt.inputInt("딥스 > ");
    w.chinning = Prompt.inputInt("풀업 > ");
    w.squat = Prompt.inputInt("스쿼트 > ");
    w.lunge= Prompt.inputInt("런지 > ");
    w.biceps = Prompt.inputInt("이두 > ");
    w.triceps = Prompt.inputInt("삼두 > ");
    w.shoulder = Prompt.inputInt("어깨 > ");
    w.hLegRaise = Prompt.inputInt("복부 > ");
    w.running = Prompt.inputInt("러 닝(km) > ");
    w.hiking = Prompt.inputInt("등산(분) > ");
    w.rope =  Prompt.inputInt("배틀로프 > ");

    works[count++] = w;

  }


}


