package QLSV;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private int age;

    public Student(String id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.setAge();
    }

    public Student() {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.setAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = -this.dateOfBirth.getYear()+ LocalDateTime.now().getYear();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                '}';
    }
}
