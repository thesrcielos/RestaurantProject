package com.restaurant.project.client.infrastructure.adapters.repository;

import com.restaurant.project.client.infrastructure.adapters.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByEmail(String email);

    boolean existsByEmail(String email);

}
