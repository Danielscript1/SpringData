package com.testeweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.testeweb.course.entities.Cargo;


public interface CargoRepository extends  CrudRepository<Cargo, Integer> {



}
