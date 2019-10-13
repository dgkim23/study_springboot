package info.thecodinglive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 이 메인이 없으면 실행이 안된다.
 * 명령어 : gradle bootRun
 */
@SpringBootApplication
//위에꺼 하나가 아래 3줄임... 이거로하면 addResourceHandlers이게 안됨...
//@ComponentScan(basePackages = "info.thecodinglive.controller")
//@Configuration
//@EnableAutoConfiguration
public class UIMain {
    public static void main(String[] args) {
        SpringApplication.run(UIMain.class, args);
    }
}
