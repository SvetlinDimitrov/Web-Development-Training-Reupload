package org.trackerwebapp.customauthdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserEntity {

  private String email;
  private String name;
  private String source;
}
