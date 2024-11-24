package kz.tamoha.auth;

import kz.tamoha.auth.impl.AutomaticLogin;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import java.util.Scanner;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthOrReg {
    Scanner scan = new Scanner(System.in);
    AutomaticLogin automaticLogin;

    public AuthOrReg(AutomaticLogin automaticLogin) {
        this.automaticLogin = automaticLogin;
    }

    public void performAuthOrReg() {
        System.out.println("Войдите в систему:");
        System.out.print("Логин: ");
        String login = scan.nextLine();
        System.out.print("Пароль: ");
        String password = scan.nextLine();

        automaticLogin.checkAuth(login, password);
    }
}
