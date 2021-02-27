package com.mypr.pms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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

  static List<Calisthenics> calisthenics;
  static List<BodyBuilding> bodyBuilding;
  static List<Cardio> cardio;
  static List<BodyCheck> bodyCheck;

  static File calisFile = new File("calisFile.data");
  static File bodyBuildingFile = new File("bodyBuildingFile.data");
  static File cardioFile = new File("cardio.data");
  static File bodyCheckFile = new File("bodyCheckFile.data");

  public static void main(String[] args) {

    calisthenics = loadObject(calisFile, Calisthenics.class);
    bodyBuilding = loadObject(bodyBuildingFile, BodyBuilding.class);
    cardio = loadObject(cardioFile, Cardio.class);
    bodyCheck = loadObject(bodyCheckFile, BodyCheck.class);


    HashMap<String, MenuCommand> commandMap = new HashMap<>();

    commandMap.put("/add", new Menu_AddHandler(calisthenics, bodyBuilding, cardio, bodyCheck));
    commandMap.put("/recode", new Menu_ListHandler(calisthenics, bodyBuilding, cardio, bodyCheck));
    commandMap.put("/total", new Menu_TotalHandler(calisthenics, bodyBuilding, cardio));
    commandMap.put("/graph", new Menu_GraphHandler(cardio, bodyCheck));

    loop:
      while (true) {
        String command = Prompt.inputString(
            "-------------------------"
                + "\n[개인 운동 기록]"
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
              break loop;
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

    saveObjects(calisFile, calisthenics);
    saveObjects(bodyBuildingFile, bodyBuilding);
    saveObjects(cardioFile, cardio);
    saveObjects(bodyCheckFile, bodyCheck);
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

  @SuppressWarnings("unchecked")
  static <T extends Serializable> List<T> loadObject(File file, Class<T> dataType) {
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(file)))) {

      System.out.printf("File %s loading complete.\n", file.getName());
      return (List<T>) in.readObject();

    } catch (Exception e) {
      System.out.printf("An error occurred while saving the file %s!\n", file.getName());
      return new ArrayList<T>();
    }
  }

  static <T extends Serializable> void saveObjects(File file, List<T> dataType) {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(file)))) {

      out.writeObject(dataType);
      System.out.printf("Completion of saving file %s.\n", file.getName());

    } catch (Exception e) {
      System.out.printf("An error occurred while saving the file %s!\n", file.getName());

    }
  }

}