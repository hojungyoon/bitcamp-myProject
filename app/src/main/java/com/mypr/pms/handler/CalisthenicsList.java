package com.mypr.pms.handler;

import com.mypr.pms.domain.CalisthenicsMenu;

public class CalisthenicsList {

  private Node first;
  private Node last;
  private int cCount = 0;
  private int numCount = 0;
  private int runCount = 0;

  public void add(CalisthenicsMenu c) {
    Node node = new Node(c);
    if(last == null) {
      if(node.calisMenu.getRunning() >= 10) {
        node.calisMenu.setRunCount(runCount + 1);
      } else {
        node.calisMenu.setRunCount(runCount);
      }
      node.calisMenu.setNums(numCount + 1);
      first = node;
      last = node;
    } else {
      last.next = node;
      node.prev = last;
      last = node;
      last.calisMenu.setNums(last.prev.calisMenu.getNums() + 1);
      if(node.calisMenu.getRunning() >= 10) {
        last.calisMenu.setRunCount(last.prev.calisMenu.getRunCount() + 1);
      }
    }
    this.cCount++;
  }

  public CalisthenicsMenu[] toArray() {
    CalisthenicsMenu[] arr = new CalisthenicsMenu[cCount];

    Node cursor = first;
    int i = 0;

    while(cursor != null) {
      arr[i++] = cursor.calisMenu;
      cursor = cursor.next;
    }
    return arr;
  }

  public CalisthenicsMenu get(int calisNumber) {
    Node cursor = first;
    while (cursor != null) {
      CalisthenicsMenu c = cursor.calisMenu;
      if (c.getNums() == calisNumber) {
        return c;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public void delete(int calisNo) {
    Node cursor = first;
    while(cursor != null) {
      if(cursor.calisMenu.getNums() == calisNo) {
        this.cCount--;
        if (first == last) {
          first = last = null;
          break;
        }
        if (cursor == first) {
          first = cursor.next;
          cursor.prev = null;
        } else {
          cursor.prev.next = cursor.next;
          if (cursor.next != null) {
            cursor.next.prev = cursor.prev;
          }
        }
        if (cursor == last) {
          last = cursor.prev;
        }
        break;
      }
      cursor = cursor.next;
    }
  }

  public int lastNum() {
    Node cursor = last;
    int a = cursor.calisMenu.getNums();
    return a;
  }

  static class Node {
    CalisthenicsMenu calisMenu;
    Node next;
    Node prev;

    Node(CalisthenicsMenu c) {
      this.calisMenu = c;
    }
  }

}
