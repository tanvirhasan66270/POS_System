package pos.model;

public class User {

    private int id;
    private String userName;
    private String password;
    private String rol;

    public User() {
    }

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol() {
        this.rol = "Admin";
    }

}
