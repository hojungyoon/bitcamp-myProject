package com.mypr.pms;

import java.sql.Date;

public class MenuHandler {
  //당일 운동횟수 데이터
  static final int SIZE = 100;
  static Date[] today = new Date[SIZE];
  static int[] pushUp = new int[SIZE];
  static int[] dipping = new int[SIZE];
  static int[] chinning = new int[SIZE];
  static int[] squat = new int[SIZE];
  static int[] lunge = new int[SIZE];
  static int[] biceps = new int[SIZE];
  static int[] triceps = new int[SIZE];
  static int[] shoulder = new int[SIZE];
  static int[] hLegRaise = new int[SIZE];
  static int[] running = new int[SIZE];
  static int[] hiking = new int[SIZE];
  static int[] rope = new int[SIZE];

  static int count = 0;

  static void inputMenu() {
    System.out.println("======================");
    today[count] = Prompt.inputDay("날짜입력 > ");
    pushUp[count] = Prompt.inputInt("푸쉬업 > ");
    dipping[count] = Prompt.inputInt("딥스 > ");
    chinning[count] = Prompt.inputInt("풀업 > ");
    squat[count] = Prompt.inputInt("스쿼트 > ");
    lunge[count] = Prompt.inputInt("런지 > ");
    biceps[count] = Prompt.inputInt("이두 > ");
    triceps[count] = Prompt.inputInt("삼두 > ");
    shoulder[count] = Prompt.inputInt("어깨 > ");
    hLegRaise[count] = Prompt.inputInt("복부 > ");
    running[count] = Prompt.inputInt("러 닝(km) > ");
    hiking[count] = Prompt.inputInt("등산(분) > ");
    rope[count] =  Prompt.inputInt("배틀로프 > ");


    count++;
  }

}
