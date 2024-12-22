package com.Icwd.user.service.Repositories;

import com.Icwd.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

//repostory->for performing operation on those entries
//data operation are present in jparepository


//if you wamnt to implement any custom method or query


}
