package kz.tamoha.auth;

import kz.tamoha.auth.impl.Authenticator;
import kz.tamoha.auth.impl.Registration;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Scanner;
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthOrReg {
    Scanner scan = new Scanner(System.in);
    Authenticator authenticator;
    Registration registration;

    public AuthOrReg(Authenticator authenticator, Registration registration) {
        this.authenticator = authenticator;
        this.registration = registration;
    }

    public void performAuthOrReg() {
        System.out.println("Войдите в систему:");
        System.out.print("Логин: ");
        String login = scan.nextLine();
        System.out.print("Пароль: ");
        String password = scan.nextLine();

        authenticator.authenticate(login, password);
        registration.register(login, password);
    }
}
