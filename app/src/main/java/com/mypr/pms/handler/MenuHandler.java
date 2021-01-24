package com.mypr.pms.handler;

import com.mypr.pms.Prompt;

public class MenuHandler {
  WorkOutMenuHandler work = new WorkOutMenuHandler();

  public void recodeMenu() {
    while(true) {
      int choice = Prompt.inputInt("======================\n1.Calisthenics\n2.Weight\n> ");
      if(choice == 1) {
        work.calisRecode();
      } else if (choice == 2) {
        work.weightRecode();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

  public void totalMenu() {
    while(true) {
      int choice = Prompt.inputInt("======================\n1.Calisthenics\n2.Weight\n> ");
      if(choice == 1) {
        work.calisTotal();
      } else if (choice == 2) {
        work.weightTotal();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

}
