package com.hms.app.components.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.components.models.NavigationLink;
@Repository
public interface NavigationLinkRepository extends JpaRepository<NavigationLink, String> {

}
