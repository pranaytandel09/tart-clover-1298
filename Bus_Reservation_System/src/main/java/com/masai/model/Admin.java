package com.masai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="admin")
@NoArgsConstructor
@Getter
@Setter
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private Integer id;
	
	@Column(unique = true)
	@NotBlank(message = "mendetory feild")
	private String username;
	
	@NotBlank(message = "mendetory feild")
	private String password;

	public Admin(@NotBlank(message = "mendetory feild") String username,
			@NotBlank(message = "mendetory feild") String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
