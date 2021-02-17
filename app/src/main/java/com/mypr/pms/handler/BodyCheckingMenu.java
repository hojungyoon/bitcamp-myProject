package com.mypr.pms.handler;

import java.sql.Date;
import java.util.ArrayDeque;
import com.mypr.pms.domain.BodyChecking;
import com.mypr.util.Prompt;

public class BodyCheckingMenu {
  private ArrayDeque<BodyChecking> bodyCheck = new ArrayDeque<>();

  public void bodyCheck() {
    BodyChecking b = new BodyChecking();
    b.setDate(new Date(System.currentTimeMillis()));
    System.out.printf("입력일자 : [ %s ]", b.getDate());
    loop:
      while(true) {
        b.setTall(Prompt.inputInt("키를 입력하세요.(cm)\n> "));
        b.setBadyWeight(Prompt.inputDouble("몸무게를 입력하세요.(kg)\n> "));
        b.setMuscleMass(Prompt.inputDouble("골격근량 입력하세요.(xx.x%)\n> "));
        b.setBodyFatMass(Prompt.inputDouble("체지방률 입력하세요.(xx.x%)\n> "));
        if(reInput()) {
          continue loop;
        } else {
          massage("기록이 등록되었습니다.");
        }
      }
  }

  boolean reInput() {
    while(true) {
      String str = Prompt.inputString("이대로 입력하시겠습니까? (y/N) > ");
      if(str.equalsIgnoreCase("y")) {
        return true;
      } else if (str.equalsIgnoreCase("n")) {
        return false;
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
    }
  }

  public static void massage(String massage) {
    System.out.printf("\n-------------------------------\n"
        + "%s"
        + "\n-------------------------------\n", massage);
  }

}
