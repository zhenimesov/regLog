package kz.tamoha.auth.impl.console;

import kz.tamoha.auth.impl.Registration;
import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.basic.model.User;
import kz.tamoha.database.DataBaseGson;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ConsoleRegistration implements Registration {
    DataBaseGson data;

    @Override
    public void register(String login, String password) {
        List<User> users = data.read().getUsers();
        users.add(new User(login, password));
        data.write(new DataBaseModel(users));
    }
}