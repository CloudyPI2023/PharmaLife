package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByIdUser(Integer id);

    List<User> findByFirstNameContains(String firstName);


    @Query(value="select u from User u WHERE u.role like :x")
    public List<User> getRole(@Param("x")Role role);

    @Query("SELECT c.role, COUNT(c.role) FROM User AS c GROUP BY c.role ORDER BY c.role DESC")
    List<Object[]> countTotalUsersByRole();

}
