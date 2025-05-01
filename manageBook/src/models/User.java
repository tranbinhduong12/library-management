package models;

public class User {
    private String id; // duy nhất, k được để trống
    private String name; // k được để trống, giới hạn 100 ký tự
    private String email; // đúng định dạng email, giới hạn 200 ký tự


    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", name=" + name +
                ", email=" + email;
    }
}
