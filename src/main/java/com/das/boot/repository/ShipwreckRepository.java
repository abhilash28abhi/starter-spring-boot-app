package com.das.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.das.boot.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long>{

}
