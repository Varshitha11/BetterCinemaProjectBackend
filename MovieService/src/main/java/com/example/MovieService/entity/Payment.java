package com.example.MovieService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private double amount;

	@OneToOne
	private Booking booking;

}
