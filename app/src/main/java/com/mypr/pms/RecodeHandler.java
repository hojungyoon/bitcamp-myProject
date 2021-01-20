package com.mypr.pms;

public class RecodeHandler {

  static void Infor(String str, int ea) {
    System.out.printf(str, ea);
  }

  static void recode() {
    for (int i = 0; i < MenuHandler.count; i++) {
      System.out.println("==============================");
      System.out.printf("[%d회차]: %s\n", i+1, MenuHandler.works[i].today);
      System.out.println("-----[상  체]-----");
      Infor("푸 쉬 업 : %d회\n", MenuHandler.works[i].pushUp);
      Infor("딥스&스윙: %d회\n", MenuHandler.works[i].dipping);
      Infor("풀     업: %d회\n", MenuHandler.works[i].chinning);
      Infor("행잉-레그: %d회\n", MenuHandler.works[i].hLegRaise);
      System.out.println("-----[하  체]-----");
      Infor("스 쿼 트 : %d회\n", MenuHandler.works[i].squat);
      Infor("런     지: %d회\n", MenuHandler.works[i].lunge);
      System.out.println("-----[  팔  ]-----");
      Infor("이     두: %d회\n", MenuHandler.works[i].biceps);
      Infor("삼     두: %d회\n", MenuHandler.works[i].triceps);
      Infor("어     깨: %d회\n", MenuHandler.works[i].shoulder);
      System.out.println("-----[유산소]-----");
      Infor("러     닝: %d회\n", MenuHandler.works[i].running);
      Infor("등     산: %d회\n", MenuHandler.works[i].hiking);
      Infor("배틀 로프: %d회\n", MenuHandler.works[i].rope);
      System.out.println("==============================");
    }
  }
}
