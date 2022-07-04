package dev.paulorievrs.springapi.repository;

import dev.paulorievrs.springapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
