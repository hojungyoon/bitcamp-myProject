package com.mypr.pms.handler;

public interface Command {
  void service();
  void service(int num);
}
