package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyCheck;
import com.mypr.pms.domain.Cardio;

public abstract class AbstractGraphMenuHandler implements MenuCommand {

  protected List<Cardio> cardioList;
  protected List<BodyCheck> bodyCheckList;

  public AbstractGraphMenuHandler (List<Cardio> cardioList, List<BodyCheck> bodyCheckList) {
    this.cardioList = cardioList;
    this.bodyCheckList = bodyCheckList;
  }

}
