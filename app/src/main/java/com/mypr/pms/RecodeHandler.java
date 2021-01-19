package com.mypr.pms;

public class RecodeHandler {

  static void recodeEach(String bady, int count) {
    if(count > 0) {
      System.out.printf(bady,count);
    }
  }


  static void recode() {
    for (int i = 0; i < MenuHandler.count; i++) {
      System.out.println("======================");
      System.out.printf("[%d회차]: %s\n", i+1, MenuHandler.today[i]);
      System.out.println("-----[상  체]-----");
      recodeEach("푸 쉬 업 : %d회\n", MenuHandler.pushUp[i]);
      recodeEach("딥스&스윙: %d회\n", MenuHandler.dipping[i]);
      recodeEach("풀     업: %d회\n", MenuHandler.chinning[i]);
      recodeEach("행잉-레그: %d회\n", MenuHandler.hLegRaise[i]);

      System.out.println("-----[하  체]-----");
      recodeEach("스 쿼 트 : %d회\n", MenuHandler.squat[i]);
      recodeEach("런     지: %d회\n", MenuHandler.lunge[i]);

      System.out.println("-----[  팔  ]-----");
      recodeEach("이     두: %d회\n", MenuHandler.biceps[i]);
      recodeEach("삼     두: %d회\n", MenuHandler.triceps[i]);
      recodeEach("어     깨: %d회\n", MenuHandler.shoulder[i]);

      System.out.println("-----[유산소]-----");
      recodeEach("러     닝: %dkm\n", MenuHandler.running[i]);
      recodeEach("등     산: %d분\n", MenuHandler.hiking[i]);
      recodeEach("배틀 로프: %d회\n", MenuHandler.rope[i]);
      System.out.println("======================");
    }
  }
}
