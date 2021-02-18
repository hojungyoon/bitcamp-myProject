package com.mypr.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class CalisthenicsListHandler extends AbstractCalisthenicsHandler {

  CalisthenicsUpdateHandler update;
  CalisthenicsDeleteHandler delete;

  public CalisthenicsListHandler (List<Calisthenics> calisList, CalisthenicsUpdateHandler update
      , CalisthenicsDeleteHandler delete) {

    super (calisList);
    this.update = update;
    this.delete = delete;
  }

  public void calisRecodeList(){
    //    System.out.println();
    //    Calisthenics[] calisMenu = calisList.toArray(new Calisthenics[count]);
    //    if(calisMenu.length == 0) {
    //      System.out.println("\n입력된 정보가 없습니다.\n");
    //      return;
    //    }  
    //    for(Calisthenics c : calisMenu) {
    //      System.out.printf("[%d회차. %s]\n", c.getNums(), c.getDate());
    //    }
    //    cTodayRecode();
    //  }

    Iterator<Calisthenics> iterator = calisList.iterator();

    while (iterator.hasNext()) {
      if (calisList.size() == 0) {
        System.out.println("\n입력된 정보가 없습니다.\n");
        return;
      }
      Calisthenics c = iterator.next();
      System.out.printf("[%d회차. %s]\n", c.getNums(), c.getDate());
    }
    todayRecode();
  }

  void todayRecode() {
    int no = Prompt.inputInt("> ");
    Calisthenics c1 = findByNo(no);
    if (no == c1.getNums()) {
      System.out.printf("\n[%d회차]: %s\n", c1.getNums(), c1.getDate());
      System.out.println("-----[상  체]-----");
      recodeOutput("푸 쉬 업 : %d회\n", c1.getPushUp());
      recodeOutput("딥스&스윙: %d회\n", c1.getDipping());
      recodeOutput("풀     업: %d회\n", c1.getChinning());
      recodeOutput("행잉-레그: %d회\n", c1.gethLegRaise());
      System.out.println("-----[하  체]-----");
      recodeOutput("스 쿼 트 : %d회\n", c1.getSquat());
      recodeOutput("런     지: %d회\n", c1.getLunge());
      System.out.println("-----[유산소]-----");
      recodeOutput("러     닝: %dKm\n", c1.getRunning());
      recodeOutput("등     산: %d분\n", c1.getHiking());

      int number2 = Prompt.inputInt("\n1.update\n2.Delete\n3.뒤로가기\n> ");
      switch(number2) {
        case 1:
          update.update(no);
          break;
        case 2:
          delete.delete(no);
          break;
        case 3:
          break;
      }
    }
  }

}

