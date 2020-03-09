package ua.external.lab.registrarion;

public class Profile {
    private String role;
    private String login;
    private String password;

    public Profile(String role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public String getRole() {
        return role;
    }
}
