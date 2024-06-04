package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.MascotaRepository;
import com.example.demo.entities.Mascota;


@RestController
@RequestMapping(path="/api", produces="application/json")
@CrossOrigin(origins="*")
public class MascotaController {

	@Autowired
	private MascotaRepository mascotaRepo;


	@PostMapping(path="/mascota", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Mascota saveMascota(@RequestBody Mascota mascota) {
		return mascotaRepo.save(mascota);
	}


	@GetMapping("/mascota/{id}")
	public ResponseEntity<Mascota> mascotaById(@PathVariable("id") Long id) {
		Optional<Mascota> optMascota = mascotaRepo.findById(id);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/mascota/nombre/{name}")
	public ResponseEntity<Mascota> mascotaByName(@PathVariable("name") String name) {
		Optional<Mascota> optMascota = mascotaRepo.findByName(name);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/mascota")
	public Iterable<Mascota> allMascotas() {
		return mascotaRepo.findAll();
	}

	@PutMapping("/mascota")
	public Mascota updateMascota(@RequestBody Mascota mascota) {
		return mascotaRepo.save(mascota);
	}

	@DeleteMapping("/mascota/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMascota(@PathVariable("id") Long id) {
		mascotaRepo.deleteById(id);
	}

	@GetMapping("/mascota/youngest")
	public Iterable<Mascota> youngestMascotas() {
		PageRequest page = PageRequest.of(0, 20, Sort.by("bornDate").ascending());
		return mascotaRepo.findAll(page);
	}

	@GetMapping("/mascota/pages/{pag}")
	public Iterable<Mascota> pagesMascotas(@PathVariable("pag") int pag) {
		PageRequest page = PageRequest.of(pag, 5, Sort.by("id").ascending());
		return mascotaRepo.findAll(page);
	}



}
