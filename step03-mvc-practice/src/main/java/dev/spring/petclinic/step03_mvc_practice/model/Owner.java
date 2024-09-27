package dev.spring.petclinic.step03_mvc_practice.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// JPA가 내부적으로 사용할 기본 생성자의 접근 제어 레벨은 PROTECTED
@AllArgsConstructor
@Builder
@ToString

@Table(name = "owners")
@Entity
public class Owner extends Person {
    private String address;
    private String city;
    private String telephone;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

    public void updateOwner(Owner ownerToUpdate) {
        this.address = ownerToUpdate.getAddress();
        this.city = ownerToUpdate.getCity();
        this.telephone = ownerToUpdate.getTelephone();
        super.updatePerson(ownerToUpdate.getFirstName(), ownerToUpdate.getLastName());
    }
}

