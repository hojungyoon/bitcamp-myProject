package com.mypr.pms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import com.mypr.pms.domain.Calisthenics;
import com.mypr.pms.handler.CalisthenicsAddHandler;
import com.mypr.pms.handler.CalisthenicsCardioHandler;
import com.mypr.pms.handler.CalisthenicsDeleteHandler;
import com.mypr.pms.handler.CalisthenicsListHandler;
import com.mypr.pms.handler.CalisthenicsTotalHandler;
import com.mypr.pms.handler.CalisthenicsUpdateHandler;
import com.mypr.pms.handler.MarathonCount;
import com.mypr.util.Prompt;

public class Main {
  static ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    ArrayList<Calisthenics> calisthenics = new ArrayList<>();

    MarathonCount marathon = new MarathonCount(calisthenics);

    CalisthenicsAddHandler calisAdd = new CalisthenicsAddHandler(calisthenics);
    CalisthenicsUpdateHandler calisUpdate = new CalisthenicsUpdateHandler(calisthenics);
    CalisthenicsDeleteHandler calisDelete = new CalisthenicsDeleteHandler(calisthenics);
    CalisthenicsListHandler calisList = new CalisthenicsListHandler(calisthenics, calisUpdate, calisDelete);
    CalisthenicsTotalHandler calisTotal = new CalisthenicsTotalHandler(calisthenics);
    CalisthenicsCardioHandler calisCardio = new CalisthenicsCardioHandler(calisthenics, marathon);



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
        calisAdd.add();
      } else if (command.equalsIgnoreCase("/recode")) {
        calisList.calisRecodeList();
      } else if (command.equalsIgnoreCase("/total")) {
        calisTotal.calisTotal();
      } else if (command.equalsIgnoreCase("/marathon")) {
        calisCardio.marathonRecode();
      } else if (command.equalsIgnoreCase("/bodycheck")) {

      } else if (command.equalsIgnoreCase("/history")) {
        printCommandHistory(commandStack.iterator());
      } else if (command.equalsIgnoreCase("/history2")) {
        printCommandHistory(commandQueue.iterator());
      } else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
        System.out.println("수고하셨습니다. 적당히하세요.");
        break;
      } else {
        System.out.printf("\n잘못된 명령어 입니다.\n");
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