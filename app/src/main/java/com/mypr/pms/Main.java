package com.mypr.pms;

import com.mypr.pms.handler.WorkOutMenuHandler;

public class Main {

  public static void main(String[] args) {

    WorkOutMenuHandler workMenuHandler = new WorkOutMenuHandler();
    while (true) {
      String command = Prompt.inputString(
          "======================"
              + "\n1./add"
              + "\n2./recode"
              + "\n3./total"
              + "\n4.exit(quit)"
              + "\n명령어> ");
      if (command.equalsIgnoreCase("/add")) {
        workMenuHandler.workMenu();
      } else if (command.equalsIgnoreCase("/recode")) {

        while(true) {
          int choice = Prompt.inputInt("======================\n1.Calisthenics\n2.Weight\n> ");
          if(choice == 1) {
            workMenuHandler.calisRecode();
          } else if (choice == 2) {
            workMenuHandler.weightRecode();
          } else {
            System.out.println("재입력 바랍니다.");
            continue;
          }
          break;
        }

      } else if (command.equalsIgnoreCase("/total")) {

        while(true) {
          int choice = Prompt.inputInt("======================\n1.Calisthenics\n2.Weight\n> ");
          if(choice == 1) {
            workMenuHandler.calisTotal();
          } else if (choice == 2) {
            workMenuHandler.weightTotal();
          } else {
            System.out.println("재입력 바랍니다.");
            continue;
          }
          break;
        }

      } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
        System.out.println("수고하셨습니다. 적당히하세요.");
        break;
      } else {
        System.out.println("잘못된 명령어 입니다.");
        continue;
      }
      System.out.println();
    }
  }
}

