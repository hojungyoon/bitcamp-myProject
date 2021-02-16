package com.mypr.pms.domain;

public class CalisthenicsTotal {
  private  int pushUp = 0;
  private  int dipping = 0;
  private  int chinning = 0;
  private  int squat = 0;
  private  int lunge = 0;
  private  int shoulder = 0;
  private  int hLegRaise = 0;
  private  int running = 0;
  private  int hiking = 0;
  private  int rope = 0;
  private  int runCount;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + chinning;
    result = prime * result + dipping;
    result = prime * result + hLegRaise;
    result = prime * result + hiking;
    result = prime * result + lunge;
    result = prime * result + pushUp;
    result = prime * result + rope;
    result = prime * result + runCount;
    result = prime * result + running;
    result = prime * result + shoulder;
    result = prime * result + squat;
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
    CalisthenicsTotal other = (CalisthenicsTotal) obj;
    if (chinning != other.chinning)
      return false;
    if (dipping != other.dipping)
      return false;
    if (hLegRaise != other.hLegRaise)
      return false;
    if (hiking != other.hiking)
      return false;
    if (lunge != other.lunge)
      return false;
    if (pushUp != other.pushUp)
      return false;
    if (rope != other.rope)
      return false;
    if (runCount != other.runCount)
      return false;
    if (running != other.running)
      return false;
    if (shoulder != other.shoulder)
      return false;
    if (squat != other.squat)
      return false;
    return true;
  }
  public int getRunCount() {
    return runCount;
  }
  public void setRunCount(int runCount) {
    this.runCount = runCount;
  }
  public int getPushUp() {
    return pushUp;
  }
  public void setPushUp(int pushUp) {
    this.pushUp = pushUp;
  }
  public int getDipping() {
    return dipping;
  }
  public void setDipping(int dipping) {
    this.dipping = dipping;
  }
  public int getChinning() {
    return chinning;
  }
  public void setChinning(int chinning) {
    this.chinning = chinning;
  }
  public int getSquat() {
    return squat;
  }
  public void setSquat(int squat) {
    this.squat = squat;
  }
  public int getLunge() {
    return lunge;
  }
  public void setLunge(int lunge) {
    this.lunge = lunge;
  }
  public int getShoulder() {
    return shoulder;
  }
  public void setShoulder(int shoulder) {
    this.shoulder = shoulder;
  }
  public int gethLegRaise() {
    return hLegRaise;
  }
  public void sethLegRaise(int hLegRaise) {
    this.hLegRaise = hLegRaise;
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
}
