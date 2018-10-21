package com.demos.springbootdemos.Repository;

import com.demos.springbootdemos.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;


//SpringDataJPA提供的复杂查询接口
public interface UserJpa extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, Serializable {

}
