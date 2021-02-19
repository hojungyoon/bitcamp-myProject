package com.mypr.pms.handler;

import java.util.List;
import com.mypr.pms.domain.Calisthenics;

public abstract class AbstractMenuHandler implements MenuCommand {

  protected List<Calisthenics> calisList;

  public AbstractMenuHandler (List<Calisthenics> calisList) {
    this.calisList = calisList;
  }

}

