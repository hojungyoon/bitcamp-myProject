package com.mypr.util;

public class List {
  private Node first;
  private Node last;
  public int count = 0;
  public int rCount = 0;


  static class Node {
    Object obj;
    Node next;
    Node prev;

    Node(Object obj) {
      this.obj = obj;
    }
  }

  public void add(Object obj) {
    Node node = new Node(obj);
    if(last == null) {
      first = node;
      last = node;
    } else {
      last.next = node;
      node.prev = last;
      last = node;
    }
    this.count++;
  }


  public Object[] toArray() {
    Object[] arr = new Object[count];

    Node cursor = this.first;
    int i = 0;

    while(cursor != null) {
      arr[i++] = cursor.obj;
      cursor = cursor.next;
    }
    return arr;
  }

  public Object get(int index) {
    if(index < 0 || index > this.count) {
      return null;
    }
    int counts = 0;
    Node cursor = this.first;
    while (cursor != null) {
      if (index == count++) {
        return cursor.obj;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public boolean delete(Object obj) {
    Node cursor = first;
    while(cursor != null) {
      if(cursor.obj.equals(obj)) {
        this.count--;
        if (first == last) {
          first = last = null;
          return true;
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
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }

  public Object delete(int index) {
    if (index < 0 || index >= this.count) {
      return null;
    }

    Object deleted = null;
    int count = 0;
    Node cursor = first;
    while (cursor != null) {
      if (index == count++) {
        deleted = cursor.obj; // 삭제될 항목을 보관해 둔다.
        this.count--;
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
    return deleted;
  }

}
