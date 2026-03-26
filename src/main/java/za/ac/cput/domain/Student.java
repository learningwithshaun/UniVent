package za.ac.cput.domain;

import za.ac.cput.util.UserIdGenerator;

import java.util.List;

/**Student name: Samukelo Ndlela
 * Student number: 231116144
 * Group: 3H
 * Student.java
 * Date: 20 March 2026
 * **/
public class Student extends User {
    private String studentNumber;
    private String faculty;
    private String department;
    private int yearOfStudy;
    private List<Booking> bookings;

    public Student(Builder builder){
        super(builder);
        this.studentNumber = builder.studentNumber;
        this.faculty = builder.faculty;
        this.department = builder.department;
        this.yearOfStudy = builder.yearOfStudy;
        this.bookings = builder.bookings;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", department='" + department + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", role=" + getRole() +
                '}';
    }

    public static class Builder extends User.Builder<Builder>{
        private String studentNumber;
        private String faculty;
        private String department;
        private int yearOfStudy;
        private List<Booking> bookings;

        public Builder setStudentNumber(String studentNumber){
            this.studentNumber = studentNumber;
            return this;
        }
        public Builder setFaculty(String faculty){
            this.faculty = faculty;
            return this;
        }
        public Builder setDepartment(String department){
            this.department = department;
            return this;
        }
        public Builder setYearOfStudy(int yearOfStudy){
            this.yearOfStudy = yearOfStudy;
            return this;
        }
        public Builder setBookings(List<Booking> bookings) {
            this.bookings = bookings;
            return this;
        }


        @Override
        public Builder copy(User user) {
            super.copy(user);
            Student student = (Student) user;
            this.studentNumber = student.getStudentNumber();
            this.faculty = student.getFaculty();
            this.department = student.getDepartment();
            this.yearOfStudy = student.getYearOfStudy();
            this.bookings = student.getBookings();
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Student build() {
            if (this.getUserId() == 0) {
                this.setUserId(UserIdGenerator.getInstance().generateId());
            }
            this.setRole(RoleEnum.STUDENT);
            return new Student(this);
        }
    }
}
