package com.hms.app.components.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.components.IconCardContainerComponent;

@Repository
public interface IconCardContainerComponentRepository extends JpaRepository<IconCardContainerComponent, String> {
	

}
