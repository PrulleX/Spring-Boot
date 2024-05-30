package web.AppWithSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Поле с именем не может быть пустым.")
    @Size(min = 2, max = 255, message = "Длина имени должна составлять от 1 до 255 символов.")
    @Pattern(regexp = "^([А-Яа-яA-Za-z]+)$", message = "Имя должно начинаться с большой буквы и состоять только из букв.")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Поле с фамилией не может быть пустым.")
    @Size(min = 2, max = 255, message = "Длина фамилии должна составлять от 1 до 255 символов.")
    @Pattern(regexp = "^([А-Яа-яA-Za-z]+)$", message = "Имя должно начинаться с большой буквы и состоять только из букв.")
    private String surname;

    @Column(name = "age")
    @Min(value = 1, message = "Возраст человека не может быть равен 0.")
    private int age;

    public User() {

    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age);
    }
}
