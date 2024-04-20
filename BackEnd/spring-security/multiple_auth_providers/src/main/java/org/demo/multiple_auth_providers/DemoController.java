package org.demo.multiple_auth_providers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping
  public String hello() {
    return "Hello World";
  }
}
