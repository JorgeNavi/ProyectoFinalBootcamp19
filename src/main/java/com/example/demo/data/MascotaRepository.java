package com.example.demo.data;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entities.Mascota;

public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long> {

	Optional<Mascota> findByName(String name);

}
