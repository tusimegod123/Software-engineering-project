package com.project.softwareengineerinng.repository;

import com.project.softwareengineerinng.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(@Param("email") String email);

//    Optional<User> findAll(Sort by);
}
