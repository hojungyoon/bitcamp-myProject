package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Cardio;

public class CardioGraphHandler extends AbstractCardioHandler {

  public CardioGraphHandler (List<Cardio> cardioList) {
    super (cardioList);
  }

  @Override
  public void service() {
    Cardio[] b = cardioList.toArray(new Cardio[cardioList.size()]);
    if (b.length == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    for (Cardio b1 : b) {
      System.out.printf("\n[%s : %d Km]", b1.getDate() ,b1.getRunning());
      for (int i = 0; i < b1.getRunning(); i++) {
        System.out.print("-");
      }
      System.out.print("[*]");
    }
    System.out.println();

  }

}
