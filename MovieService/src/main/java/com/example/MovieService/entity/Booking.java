package com.example.MovieService.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "bookings")	
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private int numberOfSeats;
	private String status;

	@OneToMany(targetEntity = ShowSeatMapping.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ssmId_fk", referencedColumnName = "bookingId")
	private List<ShowSeatMapping> showSeatMappings;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(targetEntity = Show.class)
	@JoinColumn(name = "show_id_fk")
	private Show show;

}
