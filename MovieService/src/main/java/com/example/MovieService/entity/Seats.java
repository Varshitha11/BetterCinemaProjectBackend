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
@Table(name = "seats")
public class Seats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seatId;
	private int seatNumber;
	
	@OneToMany(targetEntity = ShowSeatMapping.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "stid_fk", referencedColumnName = "seatId")
	private List<ShowSeatMapping> showSeatMapping;

	

}
