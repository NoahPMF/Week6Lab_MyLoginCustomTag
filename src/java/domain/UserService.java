/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author 601354
 */
public class UserService {

    User u = new User();

    public User login(String username, String password) {

        if (username.equals("betty") || username.equals("adam")) {

            u.setUsername(username);

            if (password.equals("password")) {
                u.setPassword(password);
                return u;
            }
        }

        return null;
    }
}
