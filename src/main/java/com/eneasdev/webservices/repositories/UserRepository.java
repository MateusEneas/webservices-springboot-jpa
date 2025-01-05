package com.eneasdev.webservices.repositories;

import com.eneasdev.webservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
