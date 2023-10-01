package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}
	
	@OneToMany(mappedBy = "role")
	@JsonIgnore
	private List<User> user=new ArrayList<>();
	
	@OneToMany(mappedBy = "role")
	@JsonIgnore
	private List<Admin> admin=new ArrayList<>();

}
