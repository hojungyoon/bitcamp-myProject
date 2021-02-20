package com.mypr.pms.handler;

import java.sql.Date;
import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class CalisthenicsAddHandler extends AbstractCalisthenicsHandler {

  public CalisthenicsAddHandler (List<Calisthenics> calisList) {
    super (calisList);
  }

  @Override
  public void service() {
    Calisthenics c = new Calisthenics();
    System.out.printf("\n현재까지 진행한 회차는(%d)회 입니다.", calisList.size());
    c.setNums(Prompt.inputInt("\n회차를 입력해주세요 : "));
    loop:
      while(true) {
        int i = Prompt.inputInt("\n"
            + "1.상체\n2.하체\n3.뒤로가기\n> ");
        switch(i) {
          case 1:
            int i2 = Prompt.inputInt("\n1.전면\n2.후면\n3.복부\n4.뒤로가기\n> ");
            switch(i2) {
              case 1:
                c.setPushUp(Prompt.inputInt("푸쉬업 > "));
                c.setDipping(Prompt.inputInt("딥스 > "));
                break;
              case 2:
                c.setChinning(Prompt.inputInt("풀업 > "));
                break;
              case 3:
                c.sethLegRaise(Prompt.inputInt("복부 > "));
                break;
              case 4:
                continue loop;
            }
            break;
          case 2:
            c.setSquat(Prompt.inputInt("스쿼트 > "));
            c.setLunge(Prompt.inputInt("런지 > "));
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
        c.setDate(new Date(System.currentTimeMillis()));
        break;
      }
    calisList.add(c);
    lineMessage("기록이 등록되었습니다.");
  }

}

