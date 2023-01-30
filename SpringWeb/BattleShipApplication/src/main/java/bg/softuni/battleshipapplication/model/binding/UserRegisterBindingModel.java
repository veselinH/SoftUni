package bg.softuni.battleshipapplication.model.binding;

import bg.softuni.battleshipapplication.validation.annotation.UniqueEmail;
import bg.softuni.battleshipapplication.validation.annotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    public String username;
    public String fullName;
    public String email;
    public String password;
    public String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @UniqueUsername
    @NotNull
    @Size(min = 3, max = 10, message = "Username length must be between 3 and 30 characters.")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    @Size(min = 5, max = 20, message = "Full name length must be between 5 and 20 characters.")
    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @UniqueEmail
    @Email(message = "Enter valid email address")
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Size(min = 4, message = "Password length must be more than 3 characters.")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Size(min = 4, message = "Password length must be more than 3 characters.")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
