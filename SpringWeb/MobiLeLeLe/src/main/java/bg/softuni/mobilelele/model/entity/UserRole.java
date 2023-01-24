package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.entity.enums.Role;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    private Role name;
    private Set<User> users = new HashSet<>();

    public UserRole() {
    }

    @Column
    @Enumerated(EnumType.STRING)
    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
