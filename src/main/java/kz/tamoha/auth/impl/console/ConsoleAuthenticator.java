package kz.tamoha.auth.impl.console;

import kz.tamoha.auth.impl.Authenticator;
import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.basic.model.User;

import java.util.List;

public class ConsoleAuthenticator implements Authenticator {

    private final DataBaseModel dataBaseModel;

    public ConsoleAuthenticator(DataBaseModel dataBaseModel) {
        this.dataBaseModel = dataBaseModel;
    }
    @Override
    public void authenticate(String login, String password) {
        List<User> users = dataBaseModel.getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Вы успешно вошли в систему.");
                return;
            }
        }
        System.out.println("Неверные учетные данные.");
    }
}