package com.example.MovieService.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "screen")
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int screenId;
	private String screenName;
	private int totalNoOfSeats;

	@OneToMany(targetEntity = Show.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "screenid_fk", referencedColumnName = "screenId")
	private List<Show> shows;

	@OneToMany(targetEntity = Seats.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "scseid__fk", referencedColumnName = "screenId")
	private List<Seats> seats;

}
