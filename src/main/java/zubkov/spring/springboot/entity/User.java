package zubkov.spring.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @Size(min = 2, max = 100, message = "Name must be min 2 and max 100 symbols")
    @NotBlank(message = "Name is required field")
    @Pattern(regexp = "[A-Za-z]+", message = "Name must consist only letters")
    private String name;

    @Column(name = "lastname")
    @Size(min = 2, max = 150, message = "Lastname must be min 2 and max 150 symbols")
    @NotBlank(message = "Lastname is required field")
    @Pattern(regexp = "[A-Za-z]+", message = "Lastname must consist only letters")
    private String lastname;

    @Column(name = "age")
    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 149, message = "Age must be less than 150")
    private byte age;

    public User() {
    }

    public User(String name, String lastname, byte age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
