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
@Table(name = "shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showId;
	private String day;
	private String time;
	
	@OneToMany(targetEntity = ShowSeatMapping.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "showid_fk", referencedColumnName = "showId")
	private List<ShowSeatMapping> showSeatMappings;
	
}
