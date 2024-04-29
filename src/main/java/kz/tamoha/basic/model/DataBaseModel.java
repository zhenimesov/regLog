package kz.tamoha.basic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults( level = AccessLevel.PRIVATE)
public class DataBaseModel {
    List<User> users;
}