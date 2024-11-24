package kz.tamoha.auth.impl.console;

import kz.tamoha.auth.impl.Authenticator;
import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.basic.model.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ConsoleAuthenticator implements Authenticator {
    DataBaseModel dataBaseModel;

    public ConsoleAuthenticator(DataBaseModel dataBaseModel) {
        this.dataBaseModel = dataBaseModel;
    }
    @Override
    public boolean authenticate(String login, String password) {
        List<User> users = dataBaseModel.getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {

                return true;
            }
        }
        return false;
    }
}