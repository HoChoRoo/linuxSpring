package dev.spring.petclinic.step03_mvc_practice.service;

// Impl - Implementation의 줄임표현
// 예전에는 'I'OwnerService

// List 인터페이스
// ArrayList, LinkedList와 같이 앞에 수식어를 붙여서 더 구체적으로 하기도함

import dev.spring.petclinic.step03_mvc_practice.model.Owner;
import dev.spring.petclinic.step03_mvc_practice.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// OwnerService 인터페이스를 구현한 구현 클래스
@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public List<Owner> findAllOwnersByLastNameLike(String lastName) {
        // DB에서 조회하는 메서드 호출 작성 부분
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Owner findById(Long ownerId) {
        Optional<Owner> ownerOptional = ownerRepository.findById(ownerId);
        Owner foundOwner = ownerOptional.orElseThrow();
        return foundOwner;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public Owner update(Owner owner, Long ownerId) {
        // 갱신할 Owner 데이터 조회
        Owner foundOwner = ownerRepository.findById(ownerId).orElseThrow();
        foundOwner.updateOwner(owner);
        return foundOwner;
    }
}
