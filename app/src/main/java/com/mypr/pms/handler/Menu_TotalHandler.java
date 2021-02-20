package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.pms.domain.Cardio;
import com.mypr.util.Prompt;

public class Menu_TotalHandler extends AbstractTotalMenuHandler {

  public Menu_TotalHandler
  (List<Calisthenics> calisList, List<BodyBuilding> bodyBuildingList, List<Cardio> cardioList) {
    super (calisList, bodyBuildingList, cardioList);
  }
  CalisthenicsTotalHandler calisTotal = new CalisthenicsTotalHandler(calisList);
  BodyBuildingTotalHandler bodybuildingTotal = new BodyBuildingTotalHandler(bodyBuildingList);
  CardioTotalHandler cardioTotal = new CardioTotalHandler(cardioList);

  @Override
  public void menuService() {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics\n"
          + "2.Weight\n"
          + "3.Cardio\n"
          + "> ");
      switch (choice) {
        case 1:
          calisTotal.service();
          break;
        case 2:
          bodybuildingTotal.service();
          break;
        case 3:
          cardioTotal.service();
          break;
        default:
          System.out.println("재입력 바랍니다.");
          continue;
      }
      break;
    }
  }

}