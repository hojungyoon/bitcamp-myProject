package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class Menu_ListHandler extends AbstractMenuHandler {

  public Menu_ListHandler (List<Calisthenics> calisList) {
    super (calisList);
  }

  CalisthenicsListHandler calisRecode = new CalisthenicsListHandler(calisList);
  WeightMenuHandler weightWork = new WeightMenuHandler();

  @Override
  public void menuService(){
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics\n"
          + "2.Weight\n"
          + "> ");
      if(choice == 1) {
        calisRecode.service();
      } else if (choice == 2) {
        weightWork.weightRecodeList();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

}