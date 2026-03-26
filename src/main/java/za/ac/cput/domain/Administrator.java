package za.ac.cput.domain;

import za.ac.cput.util.UserIdGenerator;

import java.util.List;

/**Student name: Amanda Msutu
 * Student number: 222428600
 * Group: 3H
 * Administrator.java
 * Date: 21 March 2026
 * **/

public class Administrator extends User {

    private String adminLevel;
    private List<User> managedUsers;
    private List<Event> managedEvents;

    private Administrator(Builder builder) {
        super(builder);
        this.adminLevel = builder.adminLevel;
        this.managedUsers = builder.managedUsers;
        this.managedEvents = builder.managedEvents;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public List<User> getManagedUsers() {
        return managedUsers;
    }

    public List<Event> getManagedEvents() {
        return managedEvents;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminLevel='" + adminLevel + '\'' +
                ", managedUsers=" + managedUsers +
                ", managedEvents=" + managedEvents +
                '}';
    }

    public static class Builder extends User.Builder<Builder> {
        private String adminLevel;
        private List<User> managedUsers;
        private List<Event> managedEvents;

        public Builder setAdminLevel(String adminLevel) {
            this.adminLevel = adminLevel;
            return this;
        }

        public Builder setManagedUsers(List<User> managedUsers) {
            this.managedUsers = managedUsers;
            return this;
        }

        public Builder setManagedEvents(List<Event> managedEvents) {
            this.managedEvents = managedEvents;
            return this;
        }

        @Override
        public Administrator.Builder copy(User user) {
            super.copy(user);
            Administrator administrator = (Administrator) user;
            this.adminLevel = administrator.getAdminLevel();
            this.managedUsers = administrator.getManagedUsers();
            this.managedEvents = administrator.getManagedEvents();
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Administrator build() {
            if (this.getUserId() == 0) {
                this.setUserId(UserIdGenerator.getInstance().generateId());
            }
            return new Administrator(this);
        }
    }
}