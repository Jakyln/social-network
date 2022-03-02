package com.mesiproject.socialnetwork.repository;

import com.mesiproject.socialnetwork.dto.UserDto;
import com.mesiproject.socialnetwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username=:usernameOrEmail OR u.mail=:usernameOrEmail")
    User findByUsernameOrEmail(String usernameOrEmail);

    //User findUserByUsernameAndPassword(String username, String password);

}
