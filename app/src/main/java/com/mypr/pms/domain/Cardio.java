package com.mypr.pms.domain;

import java.sql.Date;

public class Cardio {
  private Date date;
  private  int num;
  private  int running;
  private  String marathonName;
  private  int hiking;
  private  int rope;

  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public int getNum() {
    return running;
  }
  public void setNum(int num) {
    this.num = num;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + hiking;
    result = prime * result + ((marathonName == null) ? 0 : marathonName.hashCode());
    result = prime * result + num;
    result = prime * result + rope;
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
    Cardio other = (Cardio) obj;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (hiking != other.hiking)
      return false;
    if (marathonName == null) {
      if (other.marathonName != null)
        return false;
    } else if (!marathonName.equals(other.marathonName))
      return false;
    if (num != other.num)
      return false;
    if (rope != other.rope)
      return false;
    if (running != other.running)
      return false;
    return true;
  }
}
