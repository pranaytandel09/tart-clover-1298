package com.masai.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class User implements UserDetails,CredentialsContainer{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	
	@Column(unique = true)
	@NotBlank(message = "mendatory feild")
	private String username;
	
	@NotBlank(message = "mendatory feild")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column(name="first_name")
	@NotBlank(message = "mendatory feild")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message = "mendatory feild")
	private String lastName;
	
	@Column(nullable =false)
	@Pattern(regexp ="[6,9][0-9]{9}", message = "invalid contact details ")
	private String contact;
	
	@NotBlank(message = "mendatory feild")
	@Pattern(regexp = "[a-z0-9.]+@[a-z0-9.]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE, message = "invalid email")
	private String email;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Reservation> reservation=new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Feedback>feedback=new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;

	public User(@NotBlank(message = "mendatory feild") String username,
			@NotBlank(message = "mendatory feild") String password,
			@NotBlank(message = "mendatory feild") String firstName,
			@NotBlank(message = "mendatory feild") String lastName,
			@Pattern(regexp = "[6,9][0-9]{9}", message = "invalid contact details ") String contact,
			@NotBlank(message = "mendatory feild") @Pattern(regexp = "[a-z0-9.]+@[a-z0-9.]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE, message = "invalid email") String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
	}

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		this.password=null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<SimpleGrantedAuthority>authSet= new HashSet<>();
		authSet.add(new SimpleGrantedAuthority(role.getName()));
		return authSet;
	}

//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return getUsername();
//	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
