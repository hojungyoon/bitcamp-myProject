package com.mypr.pms.handler;

import java.sql.Date;
import java.util.List;
import com.mypr.pms.domain.Cardio;
import com.mypr.util.Prompt;

public class CardioAddHandler extends AbstractCardioHandler {

  public CardioAddHandler (List<Cardio> cardioList) {
    super (cardioList);
  }

  @Override
  public void service() {
    Cardio c = new Cardio();
    System.out.printf("\n현재까지 진행한 회차는(%d)회 입니다.", cardioList.size());
    c.setNum(Prompt.inputInt("\n회차를 입력해주세요 : "));
    loop:
      while(true) {
        int i = Prompt.inputInt("\n"
            + "1.러닝\n2.하이킹\n3.배틀로프\n4.뒤로가기\n> ");
        switch(i) {
          case 1:
            c.setRunning(Prompt.inputInt("러 닝(km) > "));
            if (c.getRunning() >=10 ) {
              c.setMarathonName(Prompt.inputString("대회 이름 > "));
              if(c.getMarathonName() == "") {
                String practice = "연습";
                c.setMarathonName(practice);
              }
            }
            break;
          case 2:
            c.setHiking(Prompt.inputInt("등산(분) > "));
            break;
          case 3:
            c.setRope(Prompt.inputInt("배틀로프 > "));
            break;
          case 4:
            lineMessage("입력을 취소하였습니다.");
            return;
          default :
            lineMessage("재입력 바랍니다.");
            continue loop;
        }
        if(reInput()) {
          continue loop;
        }
        c.setDate(new Date(System.currentTimeMillis()));
        break;
      }
    cardioList.add(c);
    lineMessage("기록이 등록되었습니다.");
  }

}

