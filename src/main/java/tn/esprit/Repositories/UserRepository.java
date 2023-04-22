package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByIdUser(Integer id);

    List<User> findByFirstNameContains(String firstName);

    @Query("SELECT u FROM User u JOIN  ConfirmationToken c ON u.idUser=c.user.idUser Where c.token = :token")
    Optional<User> findByConfirmationToken(@Param("token") String token);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);


    @Transactional
    @Modifying
    @Query("UPDATE User a " + "SET a.password = ?1 WHERE a.email = ?2")
    void resetPassword(String password,String email);


    @Query(value="select u from User u WHERE u.role like :x")
    public List<User> getRole(@Param("x")Role role);

    @Query("SELECT c.role, COUNT(c.role) FROM User AS c GROUP BY c.role ORDER BY c.role DESC")
    List<Object[]> countTotalUsersByRole();



     List<User> findByEnabledFalseAndCreatedAtBefore(LocalDateTime date);


   /* @Query("UPDATE User u SET u.failedAttempt = ?1 WHERE u.email = ?2")
    @Modifying
    public void updateFailedAttempts(int failAttempts, String email);*/
   @Modifying
   @Transactional
   @Query("UPDATE User u SET u.loginAttempts = ?1 WHERE u.email = ?2")
   void updateLoginAttempts(int attempts, String email);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.loginAttempts =?1 WHERE u.email = ?2")
    void resetLoginAttempts(int a,String email);


   /* @Transactional
    @Modifying
    @Query("UPDATE User u SET u.locked = false, u.lockTime = :lockTime WHERE u.email = :email")
    void lockUser(@Param("email") String email, @Param("lockTime") LocalDateTime lockTime);*/
   @Transactional
   @Modifying
   @Query("UPDATE User u SET u.locked = TRUE , u.lockTime= ?1 WHERE u.email = ?2")
   int lockUser(LocalDateTime time, String email);


    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.locked = FALSE, a.lockTime=null, a.loginAttempts=0 WHERE a.email = ?1")
    void unlockUser(String email);


    @Query("SELECT u FROM User u WHERE u.locked = TRUE AND u.lockTime < :expirationTime")
    List<User> findExpiredLockUsers(@Param("expirationTime") LocalDateTime expirationTime);


}
