package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.pms.domain.Cardio;

public abstract class AbstractTotalMenuHandler implements MenuCommand {

  protected List<Calisthenics> calisList;
  protected List<BodyBuilding> bodyBuildingList;
  protected List<Cardio> cardioList;

  public AbstractTotalMenuHandler
  (List<Calisthenics> calisList, List<BodyBuilding> bodyBuildingList, List<Cardio> cardioList) {
    this.calisList = calisList;
    this.bodyBuildingList = bodyBuildingList;
    this.cardioList = cardioList;
  }

}
