package com.mypr.pms.handler;

import java.util.ArrayList;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class Menu_BodyCheckHandler {


  WeightMenuHandler weightWork = new WeightMenuHandler();

  public void bodyCheck {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Input\n"
          + "2.Recode\n"
          + "3.Graph\n"
          + "> ");
      if(choice == 1) {
        bodyCheck.bodyCheck();
      } else if (choice == 2) {
        bodyCheck.checkRecode();
      } else if (choice == 3){
        bodyCheck.graph();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

}