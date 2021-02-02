

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
  private  int biceps;
  private  int triceps;
  private  int hLegRaise;

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
  public int getBiceps() {
    return biceps;
  }
  public void setBiceps(int biceps) {
    this.biceps = biceps;
  }
  public int getTriceps() {
    return triceps;
  }
  public void setTriceps(int triceps) {
    this.triceps = triceps;
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
  public int getRunCount() {
    return runCount;
  }
  public void setRunCount(int runCount) {
    this.runCount = runCount;
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
  private  int running;
  private  int runCount;
  private  String marathonName;
  private  int hiking;
  private  int rope;
}