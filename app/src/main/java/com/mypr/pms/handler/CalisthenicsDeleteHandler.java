package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class CalisthenicsDeleteHandler extends AbstractCalisthenicsHandler {

  public CalisthenicsDeleteHandler (List<Calisthenics> calisList) {
    super (calisList);
  }

  @Override
  public void service(int number) {
    Calisthenics c = findByNo(number);
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)> ");

    if (input.equalsIgnoreCase("y")) {

      calisList.remove(c);
      lineMessage("기록을 삭제하였습니다.");
    } else {
      lineMessage("기록삭제를 취소하였습니다.");
    }
  }

  @Override
  public void service() {}

}

