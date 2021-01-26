package com.mypr.pms;

import com.mypr.pms.handler.MenuHandler;

public class Main {

  public static void main(String[] args) {

    MenuHandler menu = new MenuHandler();

    while (true) {
      String command = Prompt.inputString(
          "======================"
              + "\n1./add"
              + "\n2./recode"
              + "\n3./total"
              + "\n4./marathon"
              + "\n5.exit(quit)"
              + "\n명령어> ");
      if (command.equalsIgnoreCase("/add")) {
        menu.addMenu();
      } else if (command.equalsIgnoreCase("/recode")) {
        menu.recodeMenu();
      } else if (command.equalsIgnoreCase("/total")) {
        menu.totalMenu();
      } else if (command.equalsIgnoreCase("/marathon")) {
        menu.marathonMenu();
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

