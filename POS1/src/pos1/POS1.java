package pos1;

import pos.dao.UserDao;
import pos.model.User;

public class POS1 {
    public static void main(String[] args) {
        User u = new User("Badrul", "1234");
        UserDao dao = new UserDao();
        dao.saveUser(u);
    }

}
