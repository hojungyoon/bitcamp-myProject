package com.mypr.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class CalisthenicsCardioHandler extends AbstractCalisthenicsHandler {

  MarathonCount marathon;

  public CalisthenicsCardioHandler (List<Calisthenics> calisList, MarathonCount marathon) {
    super (calisList);
    this.marathon = marathon;
  }

  public void marathonRecode() {
    if (calisList.size() == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
    } else {
      Iterator<Calisthenics> iterator = calisList.iterator();
      System.out.printf("\n마라톤 회차: %d회\n", marathon.runningNums());
      while (iterator.hasNext()) {
        Calisthenics c = iterator.next();
        if (c.getRunning() >= 10) {
          System.out.printf("[%d회차, %s]\n", c.getNums(), c.getDate());
        }

      }

      int no = Prompt.inputInt("입력> ");
      Calisthenics m = findByNo(no);
      if (no == m.getNums()) {
        System.out.printf("\n마라톤 완주거리: %d Km\n", m.getRunning());
        System.out.printf(String.format("마라톤 완주일자: %s\n", m.getDate()));
        System.out.printf("마라톤 대회이름: %s\n", m.getMarathonName());
        System.out.println("------------------------------");
      }
    }
  }




}

