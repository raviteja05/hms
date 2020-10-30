package com.hms.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.domain.models.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
