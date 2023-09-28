package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Admin;
import com.masai.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {

	List<Bus>findAllByType(String type);
}
