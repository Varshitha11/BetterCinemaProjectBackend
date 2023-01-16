package com.example.MovieService.entity;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movies {
	
	@Id
	private Integer id;
	private String title;
	private String description;
	private String language;
	private String image;
	
	@OneToMany(targetEntity = Show.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "movieId", referencedColumnName = "id")
	private List<Show> shows;

	
}
