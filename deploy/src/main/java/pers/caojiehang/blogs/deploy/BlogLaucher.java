package pers.caojiehang.blogs.deploy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author linckye 2018-10-14
 */
@SpringBootApplication
@ComponentScan(
        "pers.caojiehang.blogs"
)
public class BlogLaucher {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(BlogLaucher.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
