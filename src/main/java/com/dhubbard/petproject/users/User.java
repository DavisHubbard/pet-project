package com.dhubbard.petproject.users;

public class User {
    private String email;
    private byte[] password;
    private byte[] salt;

    public User() {
    }

    public User(String email, byte[] password, byte[] salt) {
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            return this.email.equals(user.getEmail()) && this.password.equals(user.getPassword());
        }
        return false;
    }
}
