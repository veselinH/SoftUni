package bg.softuni.usersystem.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String username;
    private String password;
    private String email;
    private LocalDateTime registeredDate;
    private LocalDateTime lastLogin;
    private int age;
    private boolean isDeleted;

    public User() {
    }

    public User(String username, String password, String email, LocalDateTime registeredDate, LocalDateTime lastLogin, int age, boolean isDeleted) {
        setUsername(username);
        this.password = password;
        this.email = email;
        this.registeredDate = registeredDate;
        this.lastLogin = lastLogin;
        this.age = age;
        this.isDeleted = isDeleted;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        if (username.length() >= 4 && username.length() <= 30){
            this.username = username;
        } else {
            throw new IllegalArgumentException("Username must be between 4 and 30 symbols.")
        }
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }


    private void setPassword(String password) {
       if (password.length() >= 6 && password.length() <= 50){

       }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
