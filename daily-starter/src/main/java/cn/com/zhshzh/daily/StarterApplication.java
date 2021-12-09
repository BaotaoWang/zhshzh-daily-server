package cn.com.zhshzh.daily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.com.zhshzh.daily.repository.mapper")
public class StarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class);
    }
}
