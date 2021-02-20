package com.mypr.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.mypr.pms.domain.Cardio;

public class CardioTotalHandler extends AbstractCardioHandler {

  public CardioTotalHandler (List<Cardio> cardioList) {
    super (cardioList);
  }

  @Override
  public void service() {

    if (cardioList.size() == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    Cardio t = new Cardio();
    Iterator<Cardio> iterator = cardioList.iterator();
    while (iterator.hasNext()) {
      Cardio c = iterator.next();

      t.setRunning(t.getRunning() + c.getRunning());
      t.setHiking(t.getHiking() + c.getHiking());
      t.setRope(t.getRope() + c.getRope());
    }
    System.out.printf("\n[운동횟수:%d회]\n", cardioList.size());
    System.out.println("-----[유산소]-----");
    System.out.printf("러     닝: %dkm\n", t.getRunning());
    System.out.printf("등     산: %d분\n", t.getHiking());
    System.out.printf("배틀 로프: %d회\n", t.getRope());
  }

}

