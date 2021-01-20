package com.mypr.pms;

public class TotalHandler {

  static int sDay = 0;
  static int sPushUp = 0;
  static int sDipping = 0;
  static int sChinning = 0;
  static int sSquat = 0;
  static int sLunge = 0;
  static int sBieps = 0;
  static int sTriceps = 0;
  static int sShoulder = 0;
  static int sHLegRaise = 0;
  static int sRunning = 0;
  static int sHiking = 0;
  static int sRope = 0;

  static void total() {
    for (int i = 0; i < MenuHandler.count; i++) {
      sDay = i+1;
      sPushUp += MenuHandler.pushUp[i];
      sDipping += MenuHandler.dipping[i];
      sChinning += MenuHandler.chinning[i];
      sSquat += MenuHandler.squat[i];
      sLunge += MenuHandler.lunge[i];
      sBieps += MenuHandler.biceps[i];
      sTriceps += MenuHandler.triceps[i];
      sShoulder += MenuHandler.shoulder[i];
      sHLegRaise += MenuHandler.hLegRaise[i];
      sRunning += MenuHandler.running[i];
      sHiking += MenuHandler.hiking[i];
      sRope += MenuHandler.rope[i];
    }
    System.out.println("======================");
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
    System.out.printf("러     닝: %dkm\n", sRunning);
    System.out.printf("등     산: %d분\n", sHiking);
    System.out.printf("배틀 로프: %d회\n", sRope);

  }
}
