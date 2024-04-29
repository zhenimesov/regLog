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

    DataBaseModel dataBaseModel;
    DataBaseGson data = new DataBaseGson();

    public void getAuth() {
        dataBaseModel = data.wrapper();

        System.out.println("Войдите в систему:");
        System.out.print("Логин: ");
        login = scan.nextLine();
        System.out.print("Пароль: ");
        password = scan.nextLine();

        List<User> users = dataBaseModel.getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Вы успешно вошли в систему.");
                return;
            }
        }
        setRegistration(login, password);
    }

    private void setRegistration(String login, String password){
        List<User> users = data.wrapper().getUsers();

        /* System.out.println("Зарегистрируйтесь в системе:");
        System.out.print("Логин: ");
        login = scan.nextLine();
        System.out.print("Пароль: ");
        password = scan.nextLine();*/


        users.add(new User(login, password));

        DataBaseModel dataBaseModel = new DataBaseModel(users);

        data.write(dataBaseModel);
        System.out.println("Вы успешно зарегистрировались");
    }
}
