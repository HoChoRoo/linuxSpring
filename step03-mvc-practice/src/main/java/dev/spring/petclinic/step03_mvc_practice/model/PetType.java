package dev.spring.petclinic.step03_mvc_practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}

	@Column(name = "name")
	private String name;

	@Override
	public String toString() {
		return name;
	}

}
