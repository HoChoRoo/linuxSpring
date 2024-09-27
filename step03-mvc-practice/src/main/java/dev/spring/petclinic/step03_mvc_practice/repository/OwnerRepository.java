package dev.spring.petclinic.step03_mvc_practice.repository;

import dev.spring.petclinic.step03_mvc_practice.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findAllByLastNameLike(String lastName);
}
