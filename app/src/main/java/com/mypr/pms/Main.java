package com.mypr.pms;

import handler.CalisthenicsMenuHandler;

public class Main {

  public static void main(String[] args) {

    CalisthenicsMenuHandler menuHandler = new CalisthenicsMenuHandler();

    loop1:
      while (true) {
        String command = Prompt.inputString(
            "======================"
                + "\n1./add"
                + "\n2./recode"
                + "\n3./total"
                + "\n4.exit(quit)"
                + "\n명령> ");
        if (command.equalsIgnoreCase("/add")) {
          menuHandler.calisMenu();
        } else if (command.equalsIgnoreCase("/recode")) {
          menuHandler.recode();
        } else if (command.equalsIgnoreCase("/total")) {
          menuHandler.total(menuHandler);
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

