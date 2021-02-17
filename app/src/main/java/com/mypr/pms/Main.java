package com.mypr.pms;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import com.mypr.pms.handler.CalisthenicsMenuHandler;
import com.mypr.pms.handler.MenuHandler;
import com.mypr.util.Prompt;

public class Main {
  static ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) throws CloneNotSupportedException {

    MenuHandler menu = new MenuHandler();

    while (true) {
      String command = Prompt.inputString(
          "[개인 운동 기록]"
              + "\n1./add"
              + "\n2./recode"
              + "\n3./total"
              + "\n4./marathon"
              + "\n5./bodycheck"
              + "\n6./history"
              + "\n7./history2"
              + "\n8. exit(quit)"
              + "\n명령어> ");

      commandStack.push(command);
      commandQueue.offer(command);

      //      try {
      if (command.equalsIgnoreCase("/add")) {
        menu.addMenu();
      } else if (command.equalsIgnoreCase("/recode")) {
        menu.recodeMenu();
      } else if (command.equalsIgnoreCase("/total")) {
        menu.totalMenu();
      } else if (command.equalsIgnoreCase("/marathon")) {
        menu.marathonMenu();
      } else if (command.equalsIgnoreCase("/bodycheck")) {
        menu.bodyCheck();
      } else if (command.equalsIgnoreCase("/history")) {
        printCommandHistory(commandStack.iterator());
      } else if (command.equalsIgnoreCase("/history2")) {
        printCommandHistory(commandQueue.iterator());
      } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
        System.out.println("수고하셨습니다. 적당히하세요.");
        break;
      } else {
        CalisthenicsMenuHandler.massage("잘못된 명령어 입니다.");
        continue;
      }
      //      } catch (Exception e) {
      //        System.out.printf("\n잘좀 입력하세요..\n> %s%s\n", e.getClass().getName(), e.getMessage());
      //      }
      System.out.println();
    }
  }

  static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if ((++count % 5) == 0) {
        String input = Prompt.inputString("next> ");
        if (input.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

}