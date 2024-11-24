package kz.tamoha.auth.impl.console;

import kz.tamoha.auth.impl.Registration;
import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.basic.model.User;
import kz.tamoha.database.DataBaseGson;

import java.util.List;

public class ConsoleRegistration implements Registration {
    private final DataBaseGson data;

    public ConsoleRegistration(DataBaseGson data) {
        this.data = data;
    }

    @Override
    public void register(String login, String password) {
        List<User> users = data.wrapper().getUsers();
        users.add(new User(login, password));
        DataBaseModel dataBaseModel = new DataBaseModel(users);
        data.write(dataBaseModel);
        System.out.println("Вы успешно зарегистрировались");
    }
}