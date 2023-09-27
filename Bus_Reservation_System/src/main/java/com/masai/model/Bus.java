package com.masai.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bus_id")
	private Integer id;
	
	@NotBlank(message = "mendatory feild")
	@Column(name="bus_name")
	private String busName;
	
	@NotBlank(message = "mendatory feild")
	@Column(name="driver_name")
	private String driverName;

	@NotBlank(message = "mendatory feild")
	@Column(name="bus_type")
	private String type;
	
	@Column(name="arrival_time")
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime arrivalTime;
	
	@Column(name="departure_time")
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime departureTime;
	
	@Column(name="bus_seats",nullable = false)
	private int seats;
	
	@Column(name="available_bus_seats",nullable = false)
	private int availableSeats;
	
	
	@OneToOne(mappedBy = "bus")
	@JsonIgnore
	private Reservation reservation;
	
	@OneToOne(mappedBy = "bus", cascade = CascadeType.ALL)
	@JsonIgnore
	private Feedback feedback;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="route_id")
	private Route route;

	public Bus(@NotBlank(message = "mendatory feild") String busName,
			@NotBlank(message = "mendatory feild") String driverName,
			@NotBlank(message = "mendatory feild") String type, LocalTime arrivalTime, LocalTime departureTime,
			int seats, int availableSeats) {
		super();
		this.busName = busName;
		this.driverName = driverName;
		this.type = type;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.availableSeats = availableSeats;
	}
	
	
}
