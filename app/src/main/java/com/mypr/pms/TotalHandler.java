package com.mypr.pms;

public class TotalHandler {
  static class Sum {
    int day = 0;
    int pushUp = 0;
    int dipping = 0;
    int chinning = 0;
    int squat = 0;
    int lunge = 0;
    int biceps = 0;
    int triceps = 0;
    int shoulder = 0;
    int hLegRaise = 0;
    int running = 0;
    int hiking = 0;
    int rope = 0;
  }

  //  static Sum[] sum = new Sum[MenuHandler.SIZE];

  static void total() {
    Sum s = new Sum();

    for (int i = 0; i < MenuHandler.count; i++) {
      s.day = i+1;
      s.pushUp += MenuHandler.works[i].pushUp;
      s.dipping += MenuHandler.works[i].dipping;
      s.chinning += MenuHandler.works[i].chinning;
      s.hLegRaise += MenuHandler.works[i].hLegRaise;
      s.squat += MenuHandler.works[i].squat;
      s.lunge += MenuHandler.works[i].lunge;
      s.biceps += MenuHandler.works[i].biceps;
      s.triceps += MenuHandler.works[i].triceps;
      s.shoulder += MenuHandler.works[i].shoulder;
      s.running += MenuHandler.works[i].running;
      s.hiking += MenuHandler.works[i].hiking;
      s.rope += MenuHandler.works[i].rope;

    }
    System.out.println("==============================");
    RecodeHandler.Infor("[운동횟수:%d회]\n", s.day);
    System.out.println("-----[상  체]-----");
    RecodeHandler.Infor("푸 쉬 업 : %d회\n", s.pushUp);
    RecodeHandler.Infor("딥스&스윙: %d회\n", s.dipping);
    RecodeHandler.Infor("행잉-레그: %d회\n", s.hLegRaise);
    System.out.println("-----[하  체]-----");
    RecodeHandler.Infor("스 쿼 트 : %d회\n", s.squat);
    RecodeHandler.Infor("런     지: %d회\n", s.lunge);
    System.out.println("-----[  팔  ]-----");
    RecodeHandler.Infor("이     두: %d회\n", s.biceps);
    RecodeHandler.Infor("삼     두: %d회\n", s.triceps);
    RecodeHandler.Infor("어     깨: %d회\n", s.shoulder);
    System.out.println("-----[유산소]-----");
    RecodeHandler.Infor("러     닝: %dkm\n", s.running);
    RecodeHandler.Infor("등     산: %d분\n", s.hiking);
    RecodeHandler.Infor("배틀 로프: %d회\n", s.rope);
    System.out.println("==============================");
  }
}

