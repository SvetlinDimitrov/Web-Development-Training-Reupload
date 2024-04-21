package org.demo.method_auth.security;

import org.springframework.stereotype.Component;

@Component
public class ConditionChecker {

  public boolean checkCondition(String name){
    return name.equals("user1");
  }
}
