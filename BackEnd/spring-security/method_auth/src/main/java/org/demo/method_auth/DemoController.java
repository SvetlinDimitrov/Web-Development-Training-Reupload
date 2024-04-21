package org.demo.method_auth;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {


  @GetMapping("/test")
  @PreAuthorize("hasAuthority('write')")  // hasAuthority() hasAnyAuthority() hasRole() hasAnyRole()
  public String hello() {
    return "Hello World";
  }

  @GetMapping("/test2")
  //@PreAuthorize("hasAuthority('write') or hasAuthority('read')")
  @PreAuthorize("hasAnyAuthority('write','read')")
  public String hello2() {
    return "Hello World2";
  }

  @GetMapping("/test/{name}")
  // authentication from SecurityContext
  //@PreAuthorize("#name == authentication.name")
  @PreAuthorize("#name == authentication.principal.username or hasRole('ADMIN')")
  public String hello3(@PathVariable String name) {
    return "Hello World";
  }

  @GetMapping("/test2/{name}")
  @PreAuthorize("@conditionChecker.checkCondition(#name)")
  public String hello4(@PathVariable String name) {
    return "Hello World";
  }

  @GetMapping("/test3")
  @PostAuthorize("returnObject != 'Hello World'") // is mainly used when we want to restrict the access to some returned value
  public String hello5() {
    System.out.println(":)");       // never use @PostAuthorize with methods that change data
    return "Hello World";
  }
// @PreFilter  => works with either array or Collection

  @GetMapping("/test4")
  @PreFilter("filterObject.contains('a')")
  public String demo6(@RequestBody List<String> values) {
    System.out.println("Values: " + values);
    return "Demo 6";
  }

  // @PostFilter  => the returned type must be either a Collection or an array

  @GetMapping("/test5")
  @PostFilter("filterObject.contains('a')")
  public List<String> demo6() {
    var list = new ArrayList<String>();
    list.add("abcd");
    list.add("wert");
    list.add("qaaz");
    list.add("wrty");

    // List.of(...) // List.of creates and immutable collection
    return list;
  }
}
