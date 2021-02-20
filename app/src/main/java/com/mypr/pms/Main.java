package com.mypr.pms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import com.mypr.pms.domain.BodyBuilding;
import com.mypr.pms.domain.BodyCheck;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.pms.domain.Cardio;
import com.mypr.pms.handler.MenuCommand;
import com.mypr.pms.handler.Menu_AddHandler;
import com.mypr.pms.handler.Menu_GraphHandler;
import com.mypr.pms.handler.Menu_ListHandler;
import com.mypr.pms.handler.Menu_TotalHandler;
import com.mypr.util.Prompt;

public class Main {
  static ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    ArrayList<Calisthenics> calisthenics = new ArrayList<>();
    ArrayList<BodyBuilding> bodyBuilding = new ArrayList<>();
    ArrayList<Cardio> cardio = new ArrayList<>();
    ArrayList<BodyCheck> bodyCheck = new ArrayList<>();

    HashMap<String, MenuCommand> commandMap = new HashMap<>();

    commandMap.put("/add", new Menu_AddHandler(calisthenics, bodyBuilding, cardio, bodyCheck));
    commandMap.put("/recode", new Menu_ListHandler(calisthenics, bodyBuilding, cardio, bodyCheck));
    commandMap.put("/total", new Menu_TotalHandler(calisthenics, bodyBuilding, cardio));
    commandMap.put("/graph", new Menu_GraphHandler(cardio, bodyCheck));

    while (true) {
      String command = Prompt.inputString(
          "[개인 운동 기록]"
              + "\n1./add"
              + "\n2./recode"
              + "\n3./total"
              + "\n4./Graph"
              + "\n5./history"
              + "\n6./history2"
              + "\n7. exit(quit)"
              + "\n명령어> ");

      commandStack.push(command);
      commandQueue.offer(command);

      try {
        switch (command) {
          case "/history":
            printCommandHistory(commandStack.iterator());
          case "/history2":
            printCommandHistory(commandQueue.iterator());
          case "exit":
          case "quit":
            System.out.println("수고하셨습니다. 적당히하세요.");
            break;
          default:
            MenuCommand commandHandler = commandMap.get(command);

            if (commandHandler == null) {
              System.out.printf("\n실행할 수 없는 명령입니다.\n");
            } else {
              commandHandler.menuService();
            }
        }
      }catch (Exception e) {
        System.out.printf("\n잘좀 입력하세요..\n> %s%s\n", e.getClass().getName(), e.getMessage());
      }
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