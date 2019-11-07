package com.chris.helloworld.repo;

import org.springframework.data.repository.CrudRepository;

import com.chris.helloworld.member.CurrentUsers;;
public interface UserRepository extends CrudRepository<CurrentUsers, Integer> {

}
