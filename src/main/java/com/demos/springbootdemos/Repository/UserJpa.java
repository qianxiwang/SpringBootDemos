package com.demos.springbootdemos.Repository;

import com.demos.springbootdemos.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;


//SpringDataJPA提供的复杂查询接口
public interface UserJpa extends JpaRepository<User, Long>,  Serializable {

    @Query(value = "select * from user where age >?", nativeQuery = true)
    public List<User> nativeQuery(int age);

    @Modifying
    @Query(value = "delete from user where name =? and password =?", nativeQuery = true)
    public void deleteQuery(String name, String password);
}
