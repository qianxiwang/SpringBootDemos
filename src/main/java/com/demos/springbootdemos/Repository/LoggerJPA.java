package com.demos.springbootdemos.Repository;

import com.demos.springbootdemos.Domain.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerJPA extends JpaRepository<LoggerEntity, Long> {


}
