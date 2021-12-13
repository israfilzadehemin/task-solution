package com.task.helmestask.repository;

import com.task.helmestask.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserIdIgnoreCase(String userId);

}
