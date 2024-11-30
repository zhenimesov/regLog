package kz.tamoha.auth;

import kz.tamoha.auth.impl.AutomaticLogin;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.Scanner;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthOrReg {
    Scanner scan = new Scanner(System.in);
    AutomaticLogin automaticLogin;

    public void performAuthOrReg() {
        System.out.println("Войдите в систему:");

        System.out.print("Логин: ");
        String login = scan.nextLine();

        System.out.print("Пароль: ");
        String password = scan.nextLine();

        // Проверка на пустоту
        if (login.isEmpty() || password.isEmpty()) {
            System.out.println("Логин или пароль не могут быть пустыми.");
            return;
        }

        automaticLogin.checkAuth(login, password);
    }
}
