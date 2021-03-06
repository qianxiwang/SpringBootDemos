package com.demos.springbootdemos.Controller;

import com.demos.springbootdemos.Domain.User;
import com.demos.springbootdemos.Repository.UserJpa;
import com.demos.springbootdemos.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Springboot集成spring data jpa进行crud操作
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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
     * 添加、更新用户的方法
     * <p>
     * http://127.0.0.1:8080/user/save?name=admin&age=22&address=jinan
     * 添加
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
     * <p>
     * http://127.0.0.1:8080/user/delete?id=2
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public List<User> delete(Long id) {
        userJpa.deleteById(id);
        return userJpa.findAll();
    }


    /**
     * 查询年龄大于20岁的用户
     *
     * @return
     */
    @RequestMapping("/age")
    public List<User> ages() {
        return userJpa.nativeQuery(20);
    }

    /**
     * 根据用户名、密码删除一条数据
     *
     * @return
     */
    @RequestMapping("/deleteWhere")
    public String deleteWhere() {
        userJpa.deleteQuery("a", "shanghai");
        return "自定义SQL删除数据成功";
    }


    @RequestMapping("/lists")
    public List<User> list(){
        return userService.getList();
    }
}
