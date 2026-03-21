package za.ac.cput.domain;

import java.util.List;

public class Administrator extends User {

    private String adminLevel;
    private List<User> managedUsers;
    //TODO: add events attribute once Event class exists

    private Administrator(Builder builder) {
        super(builder);
        this.adminLevel = builder.adminLevel;
        this.managedUsers = builder.managedUsers;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public List<User> getManagedUsers() {
        return managedUsers;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminLevel='" + adminLevel + '\'' +
                ", managedUsers=" + managedUsers +
                '}';
    }

    public static class Builder extends User.Builder<Builder> {
        private String adminLevel;
        private List<User> managedUsers;

        public Builder setAdminLevel(String adminLevel) {
            this.adminLevel = adminLevel;
            return this;
        }

        public Builder setManagedUsers(List<User> managedUsers) {
            this.managedUsers = managedUsers;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Administrator build() {
            return new Administrator(this);
        }
    }
}