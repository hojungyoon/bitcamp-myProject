package com.mypr.pms.domain;

public class WeightTotal {
  public int dPress = 0;
  public int inDpress = 0;
  public int dFly = 0;
  public int inFly = 0;
  public int bicepsCurl = 0;
  public int tricepOver = 0;
  public int lateralRaise = 0;
  public int shoulderPress = 0;
  public int bentoverLateral = 0;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + bentoverLateral;
    result = prime * result + bicepsCurl;
    result = prime * result + dFly;
    result = prime * result + dPress;
    result = prime * result + dumbellPullover;
    result = prime * result + inDpress;
    result = prime * result + inFly;
    result = prime * result + lateralRaise;
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
    WeightTotal other = (WeightTotal) obj;
    if (bentoverLateral != other.bentoverLateral)
      return false;
    if (bicepsCurl != other.bicepsCurl)
      return false;
    if (dFly != other.dFly)
      return false;
    if (dPress != other.dPress)
      return false;
    if (dumbellPullover != other.dumbellPullover)
      return false;
    if (inDpress != other.inDpress)
      return false;
    if (inFly != other.inFly)
      return false;
    if (lateralRaise != other.lateralRaise)
      return false;
    if (shoulderPress != other.shoulderPress)
      return false;
    if (tricepOver != other.tricepOver)
      return false;
    return true;
  }
  public int dumbellPullover = 0;


}
