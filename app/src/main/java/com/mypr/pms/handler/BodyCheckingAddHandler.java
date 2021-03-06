package com.mypr.pms.handler;

import java.sql.Date;
import java.util.List;
import com.mypr.pms.domain.BodyCheck;
import com.mypr.util.Prompt;

public class BodyCheckingAddHandler extends AbstractBodyCheckingHandler {

  public BodyCheckingAddHandler (List<BodyCheck> bodyCheckList) {
    super (bodyCheckList);
  }

  @Override
  public void service() {
    BodyCheck b = new BodyCheck();
    b.setDate(new Date(System.currentTimeMillis()));
    System.out.printf("입력일자 : [ %s ] - %d회\n",  b.getDate(), bodyCheckList.size());
    b.setNum(Prompt.inputInt("\n회차를 입력해주세요 : "));
    b.setTall(Prompt.inputDouble("키를 입력하세요.(xxx.x cm)\n> "));
    b.setBadyWeight(Prompt.inputDouble("몸무게를 입력하세요.(xx.x kg)\n> "));
    b.setMuscleMass(Prompt.inputDouble("골격근량 입력하세요.(xx.x %%)\n> "));
    b.setBodyFatMass(Prompt.inputDouble("체지방률 입력하세요.(xx.x %%)\n> "));
    bodyCheckList.add(b);
    lineMessage("기록이 등록되었습니다.");
  }

}
