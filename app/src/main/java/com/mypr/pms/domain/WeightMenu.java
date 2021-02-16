package com.mypr.pms.domain;

import java.sql.Date;

public class WeightMenu {

  private int nums;
  private  Date date;
  private int dPress;
  private int inDpress;
  private int dFly;
  private int inFly;
  private int bicepsCurl;
  private int tricepOver;
  private int lateralRaise;
  private int shoulderPress;
  private int bentoverLateral;
  private int dumbellPullover;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + bentoverLateral;
    result = prime * result + bicepsCurl;
    result = prime * result + dFly;
    result = prime * result + dPress;
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + dumbellPullover;
    result = prime * result + inDpress;
    result = prime * result + inFly;
    result = prime * result + lateralRaise;
    result = prime * result + nums;
    result = prime * result + shoulderPress;
    result = prime * result + tricepOver;
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
    WeightMenu other = (WeightMenu) obj;
    if (bentoverLateral != other.bentoverLateral)
      return false;
    if (bicepsCurl != other.bicepsCurl)
      return false;
    if (dFly != other.dFly)
      return false;
    if (dPress != other.dPress)
      return false;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (dumbellPullover != other.dumbellPullover)
      return false;
    if (inDpress != other.inDpress)
      return false;
    if (inFly != other.inFly)
      return false;
    if (lateralRaise != other.lateralRaise)
      return false;
    if (nums != other.nums)
      return false;
    if (shoulderPress != other.shoulderPress)
      return false;
    if (tricepOver != other.tricepOver)
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
  public int getdPress() {
    return dPress;
  }
  public void setdPress(int dPress) {
    this.dPress = dPress;
  }
  public int getInDpress() {
    return inDpress;
  }
  public void setInDpress(int inDpress) {
    this.inDpress = inDpress;
  }
  public int getdFly() {
    return dFly;
  }
  public void setdFly(int dFly) {
    this.dFly = dFly;
  }
  public int getInFly() {
    return inFly;
  }
  public void setInFly(int inFly) {
    this.inFly = inFly;
  }
  public int getBicepsCurl() {
    return bicepsCurl;
  }
  public void setBicepsCurl(int bicepsCurl) {
    this.bicepsCurl = bicepsCurl;
  }
  public int getTricepOver() {
    return tricepOver;
  }
  public void setTricepOver(int tricepOver) {
    this.tricepOver = tricepOver;
  }
  public int getLateralRaise() {
    return lateralRaise;
  }
  public void setLateralRaise(int lateralRaise) {
    this.lateralRaise = lateralRaise;
  }
  public int getShoulderPress() {
    return shoulderPress;
  }
  public void setShoulderPress(int shoulderPress) {
    this.shoulderPress = shoulderPress;
  }
  public int getBentoverLateral() {
    return bentoverLateral;
  }
  public void setBentoverLateral(int bentoverLateral) {
    this.bentoverLateral = bentoverLateral;
  }
  public int getDumbellPullover() {
    return dumbellPullover;
  }
  public void setDumbellPullover(int dumbellPullover) {
    this.dumbellPullover = dumbellPullover;
  }


}
