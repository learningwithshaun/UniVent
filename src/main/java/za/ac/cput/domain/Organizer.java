package za.ac.cput.domain;

public class Organizer extends User {

    private String organizationName;
    private String organizationType;
    private String contactEmail;
    //TODO: add events attribute once Event class exists

    private Organizer(Builder builder) {
        super(builder);
        this.organizationName = builder.organizationName;
        this.organizationType = builder.organizationType;
        this.contactEmail = builder.contactEmail;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "organizationName='" + organizationName + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }

    public static class Builder extends User.Builder<Builder> {
        private String organizationName;
        private String organizationType;
        private String contactEmail;

        public Builder setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
            return this;
        }

        public Builder setOrganizationType(String organizationType) {
            this.organizationType = organizationType;
            return this;
        }

        public Builder setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Organizer build() {
            return new Organizer(this);
        }
    }
}
