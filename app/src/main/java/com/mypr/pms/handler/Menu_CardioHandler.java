package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Calisthenics;

public class Menu_CardioHandler extends AbstractMenuHandler {

  public Menu_CardioHandler(List<Calisthenics> calisList) {
    super (calisList);
  }

  CalisthenicsCardioHandler calisCardio = new CalisthenicsCardioHandler(calisList);

  WeightMenuHandler weightWork = new WeightMenuHandler();

  @Override
  public void menuService() {
    calisCardio.service();
  }

}