package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	
	@Column(unique = true)
	@NotBlank(message = "mendatory feild")
	private String username;
	
	@NotBlank(message = "mendatory feild")
	private String password;
	
	@Column(name="first_name")
	@NotBlank(message = "mendatory feild")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message = "mendatory feild")
	private String lastName;
	
	@Column(nullable =false)
	@Pattern(regexp ="[6,9][0-9]{9}", message = "invalid contact details ")
	private Long contact;
	
	@NotBlank(message = "mendatory feild")
	@Pattern(regexp = "[a-z0-9.]+@[a-z0-9.]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE, message = "invalid email")
	private String email;
	
	@OneToMany(mappedBy = "user")
	@JoinColumn(name="reservation_id")
	@JsonIgnore
	private List<Reservation> reservation;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Feedback>feedback;
	
	@OneToOne
	@JsonIgnore
	private Role role;

	public User(@NotBlank(message = "mendatory feild") String username,
			@NotBlank(message = "mendatory feild") String password,
			@NotBlank(message = "mendatory feild") String firstName,
			@NotBlank(message = "mendatory feild") String lastName,
			@Pattern(regexp = "[6,9][0-9]{9}", message = "invalid contact details ") Long contact,
			@NotBlank(message = "mendatory feild") @Pattern(regexp = "[a-z0-9.]+@[a-z0-9.]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE, message = "invalid email") String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
	}
	
	
}
