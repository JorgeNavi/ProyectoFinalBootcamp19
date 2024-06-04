package com.example.demo.data;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Mascota;

@Repository
public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long> {

	Optional<Mascota> findById(Long id);

	Iterable<Mascota> findAll();

	void deleteById(Long id);

	Mascota save(Mascota mascota);

	Optional<Mascota> findByName(String name);

}
