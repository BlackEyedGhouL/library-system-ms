/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userservicedb;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Senith Umesha
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
 
         
    @Transactional
    @Modifying
    @Query("delete from User u where u.name=?1")
    void deleteUserByName(String name);
    
    @Query("select u from User u where u.name=?1 and u.password=?2")
    List<User> findUserByNameAndPassword(String name, String password);
}
