package com.chris.helloworld.main;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<CurrentUsers, Integer> {

}
