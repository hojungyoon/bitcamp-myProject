package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.BodyCheck;
import com.mypr.pms.domain.Cardio;
import com.mypr.util.Prompt;

public class Menu_GraphHandler extends AbstractGraphMenuHandler {

  public Menu_GraphHandler (List<Cardio> cardioList, List<BodyCheck> bodyCheckList) {
    super (cardioList, bodyCheckList);
  }

  CardioGraphHandler cardioGraph = new CardioGraphHandler(cardioList);
  BodyCheckingGraphHandler bodyCheckGraph = new BodyCheckingGraphHandler(bodyCheckList);


  @Override
  public void menuService() {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Cardio"
          + "\n2.BodyCheck"
          + "\n> ");
      switch (choice) {
        case 1:
          cardioGraph.service();
          break;
        case 2:
          bodyCheckGraph.service();
          break;
        default:
          System.out.println("재입력 바랍니다.");
          continue;
      }
      break;
    }
  }

}