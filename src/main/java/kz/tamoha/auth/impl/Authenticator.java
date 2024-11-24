package kz.tamoha.auth.impl;

public interface Authenticator {
    boolean authenticate(String login, String password);
}
