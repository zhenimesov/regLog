package kz.tamoha;

import kz.tamoha.auth.AuthOrReg;
import kz.tamoha.auth.impl.Authenticator;
import kz.tamoha.auth.impl.Registration;
import kz.tamoha.auth.impl.console.ConsoleAuthenticator;
import kz.tamoha.auth.impl.console.ConsoleRegistration;
import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.database.DataBaseGson;

public class Main {
    public static void main(String[] args) {
        DataBaseGson dataBaseGson = new DataBaseGson();
        DataBaseModel dataBaseModel = dataBaseGson.wrapper();

        Authenticator authenticator = new ConsoleAuthenticator(dataBaseModel);
        Registration registration = new ConsoleRegistration(dataBaseGson);

        AuthOrReg authOrReg = new AuthOrReg(authenticator, registration);
        authOrReg.performAuthOrReg();
    }
}

