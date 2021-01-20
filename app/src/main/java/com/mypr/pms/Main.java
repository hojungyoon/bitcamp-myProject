package com.mypr.pms;

public class Main {

  public static void main(String[] args) {

    loop1:
      while (true) {
        String command = Prompt.inputString(
            "======================\n1./add\n2./recode\n3./total\n4.exit(quit)\n명령> ");

        if (command.equalsIgnoreCase("/add")) {
          MenuHandler.Menu();
          MenuHandler.works[MenuHandler.count++] = MenuHandler.w;
        } else if (command.equalsIgnoreCase("/recode")) {
          RecodeHandler.recode();
        } else if (command.equalsIgnoreCase("/total")) {
          TotalHandler.total();
        } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
          System.out.println("수고하셨습니다. 적당히하세요.");
          break;

        } else {
          System.out.println("잘못된 명령어 입니다.");
        }
        System.out.println();
      }
  }
}

