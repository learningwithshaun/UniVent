package za.ac.cput.domain;
/**Student name: Samukelo Ndlela
 * Student number: 231116144
 * Group: 3H
 * User.java
 * Date: 20 March 2026
 * **/

public abstract class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private RoleEnum role;

    protected User(Builder <?> builder){
        this.userId = builder.userId;
        this.name =builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RoleEnum getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                '}';
    }

    public abstract static class Builder<T extends Builder<T>>{
        private int userId;
        private String name;
        private String email;
        private String password;
        private String phoneNumber;
        private RoleEnum role;

        public T setUserId(int userId){
            this.userId = userId;
            return self();
        }
        public int getUserId() {
            return userId;
        }
        public T setName(String name){
            this.name = name;
            return self();
        }
        public T setEmail(String email) {
            this.email = email;
            return self();
        }
        public T setPassword(String password) {
            this.password = password;
            return self();
        }
        public T setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return self();
        }
        public T setRole(RoleEnum role) {
            this.role = role;
            return self();
        }
        public T copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.email = user.email;
            this.password = user.password;
            this.phoneNumber = user.phoneNumber;
            this.role = user.role;
            return self();
        }

        protected abstract T self();
        public abstract User build();

    }
}
