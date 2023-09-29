package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Integer id;
	
	@NotBlank
	@Column(name="reservation_status")
	private String status;
	
	@NotBlank
	@Column(name="reservation_type")
	private String type;
	
	@Column(name="reservation_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate reservationDate;
	
	@Column(name="reservation_time")
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime localTime;
	
	@NotBlank(message = "mendatory feild")
	private String source;
	
	@NotBlank(message = "mendatory feild")
	private String destination;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bus_id")
	private Bus bus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	public Reservation(@NotBlank String status, @NotBlank String type, LocalDate reservationDate, LocalTime localTime,
			@NotBlank(message = "mendatory feild") String source,
			@NotBlank(message = "mendatory feild") String destination) {
		super();
		this.status = status;
		this.type = type;
		this.reservationDate = reservationDate;
		this.localTime = localTime;
		this.source = source;
		this.destination = destination;
	}
	
	
}
