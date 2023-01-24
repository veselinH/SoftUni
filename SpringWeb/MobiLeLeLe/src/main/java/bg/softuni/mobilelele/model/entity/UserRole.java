package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.Role;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    private Role name;
    private Set<User> users;

    public UserRole() {
    }

    @Column
    @Enumerated(EnumType.ORDINAL)
    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

    @ManyToMany
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
