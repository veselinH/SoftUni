package bg.softuni.mobilelele.repository;

import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(Role name);
}
