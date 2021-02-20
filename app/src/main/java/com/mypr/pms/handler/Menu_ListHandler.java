package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.pms.domain.BodyCheck;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.pms.domain.Cardio;
import com.mypr.util.Prompt;

public class Menu_ListHandler extends AbstractMenuHandler{

  public Menu_ListHandler
  (List<Calisthenics> calisList, List<BodyBuilding> bodyBuildingList,
      List<Cardio> cardioList, List<BodyCheck> bodyCheckList) {
    super (calisList, bodyBuildingList, cardioList, bodyCheckList);
  }

  CalisthenicsListHandler calisRecode = new CalisthenicsListHandler(calisList);
  BodyBuildingListHandler bodyBuidingRecode = new BodyBuildingListHandler(bodyBuildingList);
  CardioListHandler cardioRecode = new CardioListHandler(cardioList);
  BodyCheckingListHandler bodyCheckRecode = new BodyCheckingListHandler(bodyCheckList);

  @Override
  public void menuService() {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics"
          + "\n2.Weight"
          + "\n3.Cardio"
          + "\n4.BodyCheck"
          + "\n> ");
      switch (choice) {
        case 1:
          calisRecode.service();
          break;
        case 2:
          bodyBuidingRecode.service();
          break;
        case 3:
          cardioRecode.service();
          break;
        case 4:
          bodyCheckRecode.service();
        default:
          System.out.println("재입력 바랍니다.");
          continue;
      }
      break;
    }
  }


}