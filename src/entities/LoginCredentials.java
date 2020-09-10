package entities;

public final class LoginCredentials {
    private final String login;
    private final String password;

    public LoginCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        // will be used during sign in process
        return login;
    }

    public String getPassword() {
        // will be used during sign in process
        return password;
    }
}
