package org.trackerwebapp.customauthdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

  @GetMapping("/demo")
  public String demo() {
    return "Demo";
  }

  @PostMapping("/demo2")
  public String demo2() {
    return "Demo2";
  }
}
