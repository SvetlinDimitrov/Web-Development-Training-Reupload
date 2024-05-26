package org.trackerwebapp.oauth0;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackerwebapp.oauth0.domein.dto.ResponseDTO;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class Auth0TestController {

  @GetMapping(value = "/public")
  public ResponseDTO publicEndpoint() {
    return new ResponseDTO("Public Endpoint Working fine !");
  }

  @GetMapping(value = "/private")
  public ResponseDTO privateEndpoint() {
    return new ResponseDTO("Private Endpoint Working fine !");
  }
}
