package com.mypr.pms.handler;

import java.sql.Date;
import java.util.List;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.util.Prompt;

public class BodyBuildingAddHandler extends AbstractBodyBuildingHandler {

  public BodyBuildingAddHandler (List<BodyBuilding> bodyBuildingList) {
    super (bodyBuildingList);
  }

  @Override
  public void service() {
    BodyBuilding w = new BodyBuilding();
    System.out.printf("\n현재까지 진행한 회차는(%d)회 입니다.", bodyBuildingList.size());
    w.setNums(Prompt.inputInt("\n회차를 입력해주세요 : "));
    loop:
      while(true) {
        int i = Prompt.inputInt("\n1.전면\n2.팔\n3.뒤로가기\n> ");
        switch(i) {
          case 1:
            w.setdPress(Prompt.inputInt("덤벨프레스 > "));
            w.setInDpress(Prompt.inputInt("IN.프레스 > "));
            w.setdFly(Prompt.inputInt("덤벨플라이 > "));
            w.setInFly(Prompt.inputInt("IN.플라이 > "));
            w.setDumbellPullover(Prompt.inputInt("덤벨풀오버 > "));
            break;
          case 2:
            w.setBicepsCurl(Prompt.inputInt("이두덤벨컬 > "));
            w.setTricepOver(Prompt.inputInt("오버헤드익스텐션 > "));
            w.setLateralRaise(Prompt.inputInt("레터럴라이즈 > "));
            w.setShoulderPress(Prompt.inputInt("숄더프레스 > "));
            w.setBentoverLateral(Prompt.inputInt("벤트오버 > "));
            break;
          case 3:
            lineMessage("입력을 취소하였습니다.");
            return;
          default :
            lineMessage("재입력 바랍니다.");
            continue loop;
        }
        if(reInput()) {
          continue loop;
        }
        w.setDate(new Date(System.currentTimeMillis()));
        break;
      }
    bodyBuildingList.add(w);
    lineMessage("기록이 등록되었습니다.");
  }

}