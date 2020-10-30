package com.hms.app.components.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.components.models.IconCard;

@Repository
public interface IconCardRepository extends JpaRepository<IconCard, String>{

}
