package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class Menu_AddHandler extends AbstractMenuHandler{

  public Menu_AddHandler (List<Calisthenics> calisList) {
    super (calisList);
  }

  CalisthenicsAddHandler calisAdd = new CalisthenicsAddHandler(calisList);
  WeightMenuHandler weightWork = new WeightMenuHandler();

  @Override
  public void menuService() {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics"
          + "\n2.Weight"
          + "\n> ");
      if(choice == 1) {
        calisAdd.service();
      } else if (choice == 2) {
        weightWork.weightWorkMenu();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

}