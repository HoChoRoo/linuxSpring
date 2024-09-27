package dev.spring.petclinic.step03_mvc_practice.service;

import dev.spring.petclinic.step03_mvc_practice.model.Owner;

import java.util.List;

public interface OwnerService {
    
    // LastName에 해당하는 모든 Owner 데이터 조회
    List<Owner> findAllOwnersByLastNameLike(String lastName);

    Owner findById(Long ownerId);

    Owner save(Owner owner);

    Owner update(Owner owner, Long ownerId);
}
