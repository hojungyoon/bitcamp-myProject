package com.mypr.util;

import java.lang.reflect.Array;

public class List<E> {

  private Node<E> first;
  private Node<E> last;
  protected int count = 0;

  public int count() {
    return this.count;
  }


  private static class Node<T> {
    T obj;
    Node<T> next;
    Node<T> prev;

    Node(T obj) {
      this.obj = obj;
    }
  }

  public void add(E obj) {
    Node<E> node = new Node<>(obj);

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

    Node<E> cursor = this.first;
    int i = 0;

    while(cursor != null) {
      arr[i++] = cursor.obj;
      cursor = cursor.next;
    }
    return arr;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {

    if (arr.length < count) {
      // 파라미터로 받은 배열이 현재 저장된 항목의 크기 보다 작을 경우
      // 새 배열을 만든다.
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), count);
    }
    Node<E> cursor = this.first;
    for (int i = 0; i < count; i++) {
      arr[i] = cursor.obj;
      cursor = cursor.next;
    }
    return arr;
  }


  public E get(int index) {
    if(index < 0 || index > this.count) {
      return null;
    }
    int counts = 0;
    Node<E> cursor = this.first;
    while (cursor != null) {
      if (index == counts++) {
        return cursor.obj;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public boolean delete(E obj) {
    Node<E> cursor = first;
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

  public E delete(int index) {
    if (index < 0 || index >= this.count) {
      return null;
    }

    E deleted = null;
    int count = 0;
    Node<E> cursor = first;
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

  public Iterator<E> iterator() throws CloneNotSupportedException {
    return new Iterator<E>() {
      int cursor = 0;

      @Override
      public boolean hasNext() {
        return cursor < List.this.count();
      }

      @Override
      public E next() {
        return List.this.get(cursor++);
      }
    };
  }

}
