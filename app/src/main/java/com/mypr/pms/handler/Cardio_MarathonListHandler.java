package com.mypr.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.mypr.pms.domain.Cardio;
import com.mypr.util.Prompt;

public class Cardio_MarathonListHandler extends AbstractCardioHandler {

  public Cardio_MarathonListHandler (List<Cardio> cardioList) {
    super (cardioList);
  }

  @Override
  public void service() {
    if (cardioList.size() == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
    } else {
      Iterator<Cardio> iterator = cardioList.iterator();
      System.out.printf("\n마라톤 회차: %d회\n", runningNums());
      while (iterator.hasNext()) {
        Cardio c = iterator.next();
        if (c.getRunning() >= 10) {
          System.out.printf("[%d회차, %s]\n", c.getNum(), c.getDate());
        }

      }

      int no = Prompt.inputInt("입력> ");
      Cardio m = findByNo(no);
      if (no == m.getNum()) {
        System.out.printf("\n마라톤 완주거리: %d Km\n", m.getRunning());
        System.out.printf(String.format("마라톤 완주일자: %s\n", m.getDate()));
        System.out.printf("마라톤 대회이름: %s\n", m.getMarathonName());
        System.out.println("------------------------------");
      }
    }
  }

  int runningNums() {
    int num = 0;
    for (int i = 0; i < cardioList.size(); i++) {
      if (cardioList.get(i).getRunning() >= 10) {
        num++;
      }
    }
    return num;
  }

}

