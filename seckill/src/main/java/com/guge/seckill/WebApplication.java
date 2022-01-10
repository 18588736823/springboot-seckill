package com.guge.seckill;

import com.guge.seckill.dao.UserDOMapper;
import com.guge.seckill.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = "com.guge.seckill")
@RestController
@MapperScan("com.guge.seckill.dao")
public class WebApplication {

    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/hello")
    public String home() {
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if (userDO == null) {
            return "用户不存在";
        }
        return userDO.getName();
    }

    public static void main( String[] args ) {
        SpringApplication.run(WebApplication.class,args);
    }

}
