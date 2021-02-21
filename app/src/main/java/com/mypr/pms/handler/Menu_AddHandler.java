package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.pms.domain.BodyCheck;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.pms.domain.Cardio;
import com.mypr.util.Prompt;

public class Menu_AddHandler extends AbstractMenuHandler{

  public Menu_AddHandler
  (List<Calisthenics> calisList, List<BodyBuilding> bodyBuildingList,
      List<Cardio> cardioList, List<BodyCheck> bodyCheckList) {
    super (calisList, bodyBuildingList, cardioList, bodyCheckList);
  }

  CalisthenicsAddHandler calisAdd = new CalisthenicsAddHandler(calisList);
  BodyBuildingAddHandler bodybuildingAdd = new BodyBuildingAddHandler(bodyBuildingList);
  CardioAddHandler cardioAdd = new CardioAddHandler(cardioList);
  BodyCheckingAddHandler bodyCheckAddMenu = new BodyCheckingAddHandler(bodyCheckList);

  @Override
  public void menuService() {
    loop:
      while(true) {
        int choice = Prompt.inputInt(
            "\n1.Calisthenics"
                + "\n2.Weight"
                + "\n3.Cardio"
                + "\n4.BodyCheck"
                + "\n> ");
        switch (choice) {
          case 1:
            calisAdd.service();
            break;
          case 2:
            bodybuildingAdd.service();
            break;
          case 3:
            cardioAdd.service();
            break;
          case 4:
            bodyCheckAddMenu.service();
            break;
          default:
            System.out.println("재입력 바랍니다.");
            continue loop;
        }
        break;
      }
  }

}