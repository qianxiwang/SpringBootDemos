package com.demos.springbootdemos.Controller;

import com.demos.springbootdemos.Domain.User;
import com.demos.springbootdemos.Repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

//    @Autowired
//    private UserJpa userJpa;
//
//    @RequestMapping("/login")
//    public String login(User userEntity, HttpServletRequest request) {
////        登陆成功
//        boolean flag = true;
//
//        String result = "登陆成功";
//        根据用户名查询用户是否存在
//        User user = userJpa.findOne(new Specification<User>() {
//            @Override
//            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), userEntity.getName()));
//                return null;
//            }
//        });

//        用户不存在
//        if (user == null) {
//            result = "用户不存在，登陆失败";
//        }
////        密码错误
//        else if (!user.getPassword().equals(userEntity.getPassword())) {
//            flag = false;
//            result = "用户密码不相符，登陆失败";
//        }

//        登陆成功
//        if (flag) {
//            将用户写入session
//            request.getSession().setAttribute("session_user", user);
//        }
//        return result;
//    }
//
//
//    /**
//     * 初始化登陆页面
//     */
//    @RequestMapping(value = "/login_view", method = RequestMethod.GET)
//    public String login_view() {
//        return "login";
//    }
//
//    @RequestMapping(value = "/index",method = RequestMethod.GET)
//    public String index(){
//        return "index";
//    }
}
