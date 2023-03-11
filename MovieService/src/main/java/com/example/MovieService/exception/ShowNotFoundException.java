package com.example.MovieService.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

}
