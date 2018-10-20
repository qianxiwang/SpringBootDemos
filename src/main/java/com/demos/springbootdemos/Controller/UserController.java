package com.demos.springbootdemos.Controller;

import com.demos.springbootdemos.Domain.User;
import com.demos.springbootdemos.Repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserJpa userJpa;


    /**
     * 查询所有的用户信息
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getList() {
        return userJpa.findAll();
    }

    /**
     * 添加、添加用户的方法
     *
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public User save(User user) {
        return userJpa.save(user);
    }

    /**
     * 删除用户信息，然后返回剩余用户的信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public List<User> delete(Long id) {
        userJpa.deleteById(id);
        return userJpa.findAll();
    }
}
