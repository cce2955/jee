package com.chris.helloworld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.helloworld.member.Equations;

public interface EquationRepository extends JpaRepository<Equations, Integer>{

}
