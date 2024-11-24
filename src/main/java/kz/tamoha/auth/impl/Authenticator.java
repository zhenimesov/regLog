package kz.tamoha.auth.impl;

public interface Authenticator {
    void authenticate(String login, String password);
}
