package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.pms.domain.BodyBuildingTotal;

public class BodyBuildingTotalHandler extends AbstractBodyBuildingHandler {

  public BodyBuildingTotalHandler (List<BodyBuilding> bodyBuildingList) {
    super (bodyBuildingList);
  }

  @Override
  public void service() {
    BodyBuildingTotal t = new BodyBuildingTotal();
    BodyBuilding[] wMenu = bodyBuildingList.toArray(new BodyBuilding[bodyBuildingList.size()]); 
    if (wMenu.length == 0) {
      System.out.printf("\n입력된 정보가 없습니다.\n");
      return;
    }
    for (BodyBuilding w : wMenu) {
      t.setdPress(t.getdPress() + w.getdPress());
      t.setInDpress(t.getInDpress() + w.getInDpress());
      t.setdFly(t.getdFly() + w.getdFly());
      t.setInFly(t.getInFly() + w.getInFly());
      t.setBicepsCurl(t.getBicepsCurl() + w.getBicepsCurl());
      t.setTricepOver(t.getTricepOver() + w.getTricepOver());
      t.setLateralRaise(t.getLateralRaise() + w.getLateralRaise());
      t.setShoulderPress(t.getShoulderPress() + w.getShoulderPress());
      t.setBentoverLateral(t.getBentoverLateral() + w.getBentoverLateral());
      t.setDumbellPullover(t.getDumbellPullover() + w.getDumbellPullover());

    }
    System.out.printf("\n[운동횟수:%d회]\n", bodyBuildingList.size());
    System.out.println("-----[가  슴]-----");
    System.out.printf("덤벨프레스 : %d회\n", t.getdPress());
    System.out.printf("IN.프 레 스: %d회\n", t.getInDpress());
    System.out.printf("덤벨플라이 : %d회\n", t.getdFly());
    System.out.printf("IN.플 라 이: %d회\n", t.getInFly());
    System.out.printf("덤벨 풀오버 : %d회\n", t.getDumbellPullover());
    System.out.println("-----[  팔  ]-----");
    System.out.printf("이두 덤벨컬 : %d회\n", t.getBicepsCurl());
    System.out.printf("오버헤드익스: %d회\n", t.getTricepOver());
    System.out.println("-----[어  깨]-----");
    System.out.printf("레터럴라이즈: %d회\n", t.getLateralRaise());
    System.out.printf("숄더 프레스 : %d회\n", t.getShoulderPress());
    System.out.printf("벤 트 오 버 : %d회\n", t.getBentoverLateral());
  }

}