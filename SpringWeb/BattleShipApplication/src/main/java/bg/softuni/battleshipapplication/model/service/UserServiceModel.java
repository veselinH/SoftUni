package bg.softuni.battleshipapplication.model.service;

import bg.softuni.battleshipapplication.model.entity.Ship;

import java.util.HashSet;
import java.util.Set;

public class UserServiceModel {

    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private Set<Ship> ships = new HashSet<>();

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public UserServiceModel setShips(Set<Ship> ships) {
        this.ships = ships;
        return this;
    }
}
