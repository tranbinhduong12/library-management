package services;

import java.util.ArrayList;
import java.util.List;
import models.User;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void listUser() {
        for (User u : users) {
            System.out.println(u);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void updateUser(String id, String newName, String newEmail) {
        for (User u : users) {
            if(u.getId().equals(id)) {
                u.setName(newName);
                u.setEmail(newEmail);
                System.out.println("update user success");
                return;
            }
        }
        System.out.println("can not find user with id: " + id);

    }

    public void deleteUser(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) {
                users.remove(u);
            }
        }
    }

    public void searchUser(String keyword) {
        boolean found = false;
        for (User u : users) {
            if (u.getName().toLowerCase().contains(keyword) ||
            u.getEmail().toLowerCase().contains(keyword)) {
                System.out.println(u);
            }
        }
        if (!found) {
            System.out.println("can not find user with keyword: " + keyword);
        }
    }


}
