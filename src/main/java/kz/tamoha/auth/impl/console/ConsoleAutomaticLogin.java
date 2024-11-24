package kz.tamoha.auth.impl.console;

import kz.tamoha.auth.impl.Authenticator;
import kz.tamoha.auth.impl.AutomaticLogin;
import kz.tamoha.auth.impl.Registration;


public class ConsoleAutomaticLogin implements AutomaticLogin {
    final Registration registration;
    final Authenticator authenticator;


    public ConsoleAutomaticLogin(Registration registration, Authenticator authenticator) {
        this.registration = registration;
        this.authenticator = authenticator;
    }


    @Override
    public void checkAuth(String login, String password) {
        if(authenticator.authenticate(login, password)){
            System.out.println("Вы успешно вошли в систему.");
        }else {
            registration.register(login, password);
            System.out.println("Вы успешно зарегистрировались");
        }
    }
}
