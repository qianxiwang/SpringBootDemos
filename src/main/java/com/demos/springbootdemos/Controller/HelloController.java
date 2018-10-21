package com.demos.springbootdemos.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot集成jsp页面进行显示
 */
@RestController
public class HelloController {
    /**
     * 测试springboot项目是不是创建成功
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello";
    }


    /**
     * 返回index.jsp页面（注意：只能使用@Controller注解才能生效))
     * 运行的时候要将pom文件中的法宝方式改成war包的方式，然后将项目打包，使用Java -jar命令运行项目
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
