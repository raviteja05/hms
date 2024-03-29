package com.hms.app.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.domain.models.User;
import com.hms.app.domain.models.UserType;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User getUserByEmail(String userId);
	List<User> findAllByUserType(UserType userType);
	Optional<User> findUserByEmail(String userId);
	 

}
