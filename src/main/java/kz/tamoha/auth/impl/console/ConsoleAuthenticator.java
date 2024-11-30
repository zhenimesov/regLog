package kz.tamoha.auth.impl.console;

import kz.tamoha.auth.impl.Authenticator;
import kz.tamoha.basic.model.DataBaseModel;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ConsoleAuthenticator implements Authenticator {
    DataBaseModel dataBaseModel;

    @Override
    public boolean authenticate(String login, String password) {
        return dataBaseModel.getUsers()
                .stream()
                .anyMatch(u -> login.equals(u.getLogin()) && password.equals(u.getPassword())
                );
    }
}