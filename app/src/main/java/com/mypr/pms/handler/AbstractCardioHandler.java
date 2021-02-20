package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Cardio;
import com.mypr.util.Prompt;

public abstract class AbstractCardioHandler implements Command {

  protected List<Cardio> cardioList;

  public AbstractCardioHandler (List<Cardio> cardioList) {
    this.cardioList = cardioList;
  }

  protected static void lineMessage(String massage) {
    System.out.printf("\n-------------------------------\n"
        + "%s"
        + "\n-------------------------------\n", massage);
  }

  protected boolean reInput() {
    while(true) {
      String str = Prompt.inputString("계속 입력하시겠습니까? (y/N) > ");
      if(str.equalsIgnoreCase("y")) {
        return true;
      } else if (str.equalsIgnoreCase("n")) {
        return false;
      } else {
        System.out.printf("재입력 바랍니다.\n\n");
        continue;
      }
    }
  }

  protected void recodeOutput(String work, int totals) {
    if (totals > 0) {
      System.out.printf(work, totals);
    }
  }

  protected Cardio findByNo(int cardioNo) {
    Cardio[] list = cardioList.toArray(new Cardio[cardioList.size()]);
    for (Cardio b : list) {
      if (b.getNum() == cardioNo) {
        return b;
      }
    }
    return null;
  }


}

