package kz.tamoha;

import kz.tamoha.auth.AuthOrReg;
import kz.tamoha.auth.impl.Authenticator;
import kz.tamoha.auth.impl.AutomaticLogin;
import kz.tamoha.auth.impl.Registration;
import kz.tamoha.auth.impl.console.ConsoleAuthenticator;
import kz.tamoha.auth.impl.console.ConsoleAutomaticLogin;
import kz.tamoha.auth.impl.console.ConsoleRegistration;
import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.database.DataBaseGson;

public class Main {
    public static void main(String[] args) {
        // Создание объектов для работы с базой данных
        DataBaseGson dataBaseGson = new DataBaseGson();
        DataBaseModel dataBaseModel = dataBaseGson.read();

        // Создание объектов для аутентификации и регистрации
        Authenticator authenticator = new ConsoleAuthenticator(dataBaseModel);
        Registration registration = new ConsoleRegistration(dataBaseGson);

        // Создание объекта для автоматического входа
        AutomaticLogin automaticLogin = new ConsoleAutomaticLogin(registration, authenticator);

        // Создание объекта для обработки аутентификации или регистрации
        AuthOrReg authOrReg = new AuthOrReg(automaticLogin);
        authOrReg.performAuthOrReg();
    }
}

