package com.punam.orgnization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.punam.orgnization.entity.Orgnization;

public interface OrgnizationRepository extends JpaRepository<Orgnization, Long> {

	Orgnization findByCode(String code);

}
