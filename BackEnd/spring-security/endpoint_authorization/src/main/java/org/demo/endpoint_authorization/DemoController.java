package org.demo.endpoint_authorization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping
  public String demo() {
    return "Hello World";
  }

  @GetMapping("/admin")
  public String admin() {
    return "Hello Admin";
  }
}
