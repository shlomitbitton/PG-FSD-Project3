package com.sportyShoes.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Purchase {
	
	@Id
	@GeneratedValue
	private int purchaseId;
	private LocalDate purchaseDate;
	@OneToOne
	private User user;
	
}
