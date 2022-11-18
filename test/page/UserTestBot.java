package page;

public class UserTestBot {
    private static String login;
    private static String password;
    private static String Name;

    public UserTestBot(String login, String password, String name){
        this.login = login;
        this.password = password;
        this.Name = name;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        UserTestBot.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserTestBot.password = password;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String firstName) {
        UserTestBot.Name = firstName;
    }

}
