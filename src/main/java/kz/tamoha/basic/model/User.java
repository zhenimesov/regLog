package kz.tamoha.basic.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String login;
    String password;

    }

