package com.mypr.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.pms.domain.CalisthenicsTotal;

public class CalisthenicsTotalHandler extends AbstractCalisthenicsHandler{

  public CalisthenicsTotalHandler (List<Calisthenics> calisList) {
    super (calisList);
  }

  @Override
  public void service() {

    if (calisList.size() == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    CalisthenicsTotal t = new CalisthenicsTotal();
    Iterator<Calisthenics> iterator = calisList.iterator();
    while (iterator.hasNext()) {
      Calisthenics c = iterator.next();
      t.setPushUp(t.getPushUp() + c.getPushUp());
      t.setDipping(t.getDipping() + c.getDipping());
      t.setChinning(t.getChinning() + c.getChinning());
      t.sethLegRaise(t.gethLegRaise() + c.gethLegRaise());
      t.setSquat(t.getSquat() + c.getSquat());
      t.setLunge(t.getLunge() + c.getLunge());
      t.setRunning(t.getRunning() + c.getRunning());
      t.setHiking(t.getHiking() + c.getHiking());
      t.setRope(t.getRope() + c.getRope());
    }
    System.out.printf("\n[운동횟수:%d회]\n", calisList.size());
    //   System.out.printf("[마라톤횟수:%d회]\n", calisList.rCount);
    System.out.println("-----[상  체]-----");
    System.out.printf("푸 쉬 업 : %d회\n", t.getPushUp());
    System.out.printf("딥스&스윙: %d회\n", t.getDipping());
    System.out.printf("풀     업: %d회\n", t.getChinning());
    System.out.printf("행잉-레그: %d회\n", t.gethLegRaise());
    System.out.println("-----[하  체]-----");
    System.out.printf("스 쿼 트 : %d회\n", t.getSquat());
    System.out.printf("런     지: %d회\n", t.getLunge());
    System.out.println("-----[유산소]-----");
    System.out.printf("러     닝: %dkm\n", t.getRunning());
    System.out.printf("등     산: %d분\n", t.getHiking());
    System.out.printf("배틀 로프: %d회\n", t.getRope());

  }

  @Override
  public void service(int num) {}
}

