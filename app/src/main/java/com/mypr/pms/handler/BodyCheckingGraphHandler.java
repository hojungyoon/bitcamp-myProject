package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyCheck;

public class BodyCheckingGraphHandler extends AbstractBodyCheckingHandler {

  public BodyCheckingGraphHandler (List<BodyCheck> bodyCheckList) {
    super (bodyCheckList);
  }

  @Override
  public void service() {
    BodyCheck[] b = bodyCheckList.toArray(new BodyCheck[bodyCheckList.size()]);
    if (b.length == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    for (BodyCheck b1 : b) {
      System.out.printf("\n[골격근량 : %.2f]", b1.getBodyFatMass());
      for (int i = 0; i < (int) b1.getBodyFatMass(); i++) {
        System.out.print("-");
      }
      System.out.print("[*]");
    }
    System.out.println();

  }

}
