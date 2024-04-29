package kz.tamoha.auth;

import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.basic.model.User;
import kz.tamoha.database.DataBaseGson;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Scanner;
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthOrReg {
    String login;
    String password;
    Scanner scan = new Scanner(System.in);

    public boolean getAuth() {
        DataBaseGson data = new DataBaseGson();

        System.out.println("Войдите в систему:");
        System.out.print("Логин: ");
        login = scan.nextLine();
        System.out.print("Пароль: ");
        password = scan.nextLine();

        List<User> users = data.wrapper();

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Вы успешно вошли в систему.");
                return true;
            }
        }
        setRegistration(login, password);
        return false;
    }

    private void setRegistration(String login, String password){
        DataBaseGson dataBaseGson = new DataBaseGson();

        List<User> users = dataBaseGson.wrapper();

        /* System.out.println("Зарегистрируйтесь в системе:");
        System.out.print("Логин: ");
        login = scan.nextLine();
        System.out.print("Пароль: ");
        password = scan.nextLine();*/


        users.add(new User(login, password));

        DataBaseModel dataBaseModel = new DataBaseModel(users);

        dataBaseGson.write(dataBaseModel);
        System.out.println("Вы успешно зарегистрировались");
    }
}
