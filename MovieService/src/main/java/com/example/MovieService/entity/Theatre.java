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


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "theatre")
public class Theatre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int theatreId;
	private String theatreName;
	private String city;
	
	@OneToMany(targetEntity = Screen.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "thscid_fk", referencedColumnName = "theatreId")
	private List<Screen> screens;


}
