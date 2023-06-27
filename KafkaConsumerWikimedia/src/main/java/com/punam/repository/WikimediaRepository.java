package com.punam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.punam.entity.WikimediaEventData;


@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaEventData, Long> {

}
