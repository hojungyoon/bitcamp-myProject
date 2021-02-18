package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Calisthenics;

public class MarathonCount extends AbstractCalisthenicsHandler{

  public MarathonCount (List<Calisthenics> calisList) {
    super (calisList);
  }

  int runningNums() {
    int num = 0;
    for (int i = 0; i < calisList.size(); i++) {
      if (calisList.get(i).getRunning() >= 10) {
        num++;
      }
    }
    return num;
  }
}
