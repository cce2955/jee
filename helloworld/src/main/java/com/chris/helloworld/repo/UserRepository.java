package com.chris.helloworld.repo;


import org.springframework.data.jpa.repository.JpaRepository;


import com.chris.helloworld.member.CurrentUsers;;
public interface UserRepository extends JpaRepository<CurrentUsers, Integer> {

}
