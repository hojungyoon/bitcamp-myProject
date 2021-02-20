package com.mypr.pms.domain;

public class CardioTotal {
  private  int running = 0;
  private  int hiking = 0;
  private  int rope = 0;
  private  int runCount;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + hiking;
    result = prime * result + rope;
    result = prime * result + runCount;
    result = prime * result + running;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CardioTotal other = (CardioTotal) obj;
    if (hiking != other.hiking)
      return false;
    if (rope != other.rope)
      return false;
    if (runCount != other.runCount)
      return false;
    if (running != other.running)
      return false;
    return true;
  }

  public int getRunning() {
    return running;
  }
  public void setRunning(int running) {
    this.running = running;
  }
  public int getHiking() {
    return hiking;
  }
  public void setHiking(int hiking) {
    this.hiking = hiking;
  }
  public int getRope() {
    return rope;
  }
  public void setRope(int rope) {
    this.rope = rope;
  }
  public int getRunCount() {
    return runCount;
  }
  public void setRunCount(int runCount) {
    this.runCount = runCount;
  }
}
