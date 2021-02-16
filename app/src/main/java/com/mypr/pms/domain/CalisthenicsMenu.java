

package com.mypr.pms.domain;

import java.sql.Date;

public class CalisthenicsMenu {

  private int nums;
  private  Date date;
  private  int pushUp;
  private  int dipping;
  private  int chinning;
  private  int squat;
  private  int lunge;
  private  int hLegRaise;
  private  int running;
  private  String marathonName;
  private  int hiking;
  private  int rope;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + chinning;
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + dipping;
    result = prime * result + hLegRaise;
    result = prime * result + hiking;
    result = prime * result + lunge;
    result = prime * result + ((marathonName == null) ? 0 : marathonName.hashCode());
    result = prime * result + nums;
    result = prime * result + pushUp;
    result = prime * result + rope;
    result = prime * result + running;
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
    CalisthenicsMenu other = (CalisthenicsMenu) obj;
    if (chinning != other.chinning)
      return false;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (dipping != other.dipping)
      return false;
    if (hLegRaise != other.hLegRaise)
      return false;
    if (hiking != other.hiking)
      return false;
    if (lunge != other.lunge)
      return false;
    if (marathonName == null) {
      if (other.marathonName != null)
        return false;
    } else if (!marathonName.equals(other.marathonName))
      return false;
    if (nums != other.nums)
      return false;
    if (pushUp != other.pushUp)
      return false;
    if (rope != other.rope)
      return false;
    if (running != other.running)
      return false;
    if (squat != other.squat)
      return false;
    return true;
  }

  public int getNums() {
    return nums;
  }
  public void setNums(int nums) {
    this.nums = nums;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
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
  public String getMarathonName() {
    return marathonName;
  }
  public void setMarathonName(String marathonName) {
    this.marathonName = marathonName;
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