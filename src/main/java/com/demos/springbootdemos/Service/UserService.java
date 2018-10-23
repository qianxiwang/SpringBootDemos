package com.demos.springbootdemos.Service;

import com.demos.springbootdemos.Domain.User;
import com.demos.springbootdemos.Repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserJpa userJpa;

    @Cacheable
    public List<User> getList() {
        return userJpa.findAll();
    }
}
