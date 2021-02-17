package com.mypr.util;

import java.util.Scanner;

public class Prompt {
  public static Scanner scanner = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.printf(title);
    return scanner.nextLine();
  }

  public static double inputDouble(String title) {
    return Double.parseDouble(inputString(title));
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  static void close() {
    scanner.close();
  }
}
