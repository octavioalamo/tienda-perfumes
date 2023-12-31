package com.sngular.qa.ecommerce.repository;

import com.sngular.qa.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByOrderByIdAsc();

    Optional<User> findByActivationCode(String code);

    Optional<User> findByEmail(String email);

    Optional<User> findByPasswordResetCode(String code);
}
