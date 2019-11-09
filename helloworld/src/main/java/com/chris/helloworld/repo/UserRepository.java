package com.chris.helloworld.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.chris.helloworld.member.CurrentUsers;;
public interface UserRepository extends JpaRepository<CurrentUsers, Integer> {

	//Check within a repo if an account number or email exists, this will be used for error checking
	boolean existsByAccount(@Param("account") String account);
	boolean existsByEmail(@Param("email") String email);
}
