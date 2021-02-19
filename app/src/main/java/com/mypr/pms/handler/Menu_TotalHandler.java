package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class Menu_TotalHandler extends AbstractMenuHandler {

  public Menu_TotalHandler (List<Calisthenics> calisList) {
    super (calisList);
  }

  CalisthenicsTotalHandler calisTotal = new CalisthenicsTotalHandler(calisList);
  WeightMenuHandler weightWork = new WeightMenuHandler();

  @Override
  public void menuService() {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics\n"
          + "2.Weight\n"
          + "> ");
      if(choice == 1) {
        calisTotal.service();
      } else if (choice == 2) {
        weightWork.weightTotal();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

}