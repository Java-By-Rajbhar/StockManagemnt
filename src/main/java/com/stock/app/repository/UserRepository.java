package com.stock.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.entiry.User;

/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
