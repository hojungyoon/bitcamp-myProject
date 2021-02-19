package com.mypr.pms.handler;

import java.util.ArrayList;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.util.Prompt;

public class MenuHandler {

  ArrayList<Calisthenics> calisthenics = new ArrayList<Calisthenics>();


  MarathonCount marathon = new MarathonCount(calisthenics);

  CalisthenicsAddHandler calisAdd = new CalisthenicsAddHandler(calisthenics);
  CalisthenicsUpdateHandler calisUpdate = new CalisthenicsUpdateHandler(calisthenics);
  CalisthenicsDeleteHandler calisDelete = new CalisthenicsDeleteHandler(calisthenics);
  CalisthenicsListHandler calisList = new CalisthenicsListHandler(calisthenics, calisUpdate, calisDelete);
  CalisthenicsTotalHandler calisTotal = new CalisthenicsTotalHandler(calisthenics);
  CalisthenicsCardioHandler calisCardio = new CalisthenicsCardioHandler(calisthenics, marathon);





  WeightMenuHandler weightWork = new WeightMenuHandler();

  public MenuHandler add() {
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

  public void recode(){
    while(true) {
      int choice = Prompt.inputInt("\n"
          + "1.Calisthenics\n"
          + "2.Weight\n"
          + "> ");
      if(choice == 1) {
        calisList.service();
      } else if (choice == 2) {
        weightWork.weightRecodeList();
      } else {
        System.out.println("재입력 바랍니다.");
        continue;
      }
      break;
    }
  }

  public void total() {
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

  public void marathon() {
    calisCardio.service();
  }


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