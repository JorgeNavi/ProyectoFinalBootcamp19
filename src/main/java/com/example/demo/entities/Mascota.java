package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date bornDate;
	private String breed;
	private float weight;
	private boolean chip;
	private String url_photo;


	public Mascota(Long id, String name, Date bornDate, String breed, float weight, boolean chip, String url_photo) {
		super();
		this.id = id;
		this.name = name;
		this.bornDate = bornDate;
		this.breed = breed;
		this.weight = weight;
		this.chip = chip;
		this.url_photo = url_photo;
	}


	public Mascota() {
	}





}

