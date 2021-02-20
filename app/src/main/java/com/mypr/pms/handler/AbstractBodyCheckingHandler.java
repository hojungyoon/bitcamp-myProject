package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyCheck;
import com.mypr.util.Prompt;

public abstract class AbstractBodyCheckingHandler implements Command {

  protected List<BodyCheck> bodyCheckList;

  public AbstractBodyCheckingHandler (List<BodyCheck> bodyCheckList) {
    this.bodyCheckList = bodyCheckList;
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

  protected BodyCheck findByNo(int calisNo) {
    BodyCheck[] list = bodyCheckList.toArray(new BodyCheck[bodyCheckList.size()]);
    for (BodyCheck b : list) {
      if (b.getNum() == calisNo) {
        return b;
      }
    }
    return null;
  }

}

