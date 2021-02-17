package com.mypr.pms.handler;

import com.mypr.util.Prompt;

public class MenuHandler {
  CalisthenicsMenuHandler calisWork = new CalisthenicsMenuHandler();
  WeightMenuHandler weightWork = new WeightMenuHandler();

  public void addMenu() {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics"
          + "\n2.Weight"
          + "\n> ");
      if(choice == 1) {
        calisWork.calisWorkMenu();
      } else if (choice == 2) {
        weightWork.weightWorkMenu();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

  public void recodeMenu() throws CloneNotSupportedException {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics\n"
          + "2.Weight\n"
          + "> ");
      if(choice == 1) {
        calisWork.calisRecodeList();
      } else if (choice == 2) {
        weightWork.weightRecodeList();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

  public void totalMenu() {
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics\n"
          + "2.Weight\n"
          + "> ");
      if(choice == 1) {
        calisWork.calisTotal();
      } else if (choice == 2) {
        weightWork.weightTotal();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

  public void marathonMenu() {
    calisWork.marathonRecode();
  }

}