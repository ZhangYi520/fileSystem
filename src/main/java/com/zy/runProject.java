package com.zy;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.tobato.fastdfs.FdfsClientConfig;

import javax.servlet.MultipartConfigElement;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
@MapperScan(value = "com.zy.dao")
@SpringBootApplication
@EnableCaching
public class runProject {
	
	public static void main(String[] args) {
		SpringApplication.run(runProject.class, args);
	}
	@Value("${spring.http.url}")	
	private String url;
	//Tomcat大文件上传连接重置
    @Bean  
    public TomcatServletWebServerFactory tomcatEmbedded() {
    	TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }
    
      @Bean  
	  MultipartConfigElement multipartConfigElement() {  
	     MultipartConfigFactory factory = new MultipartConfigFactory();  
	     factory.setLocation(url);  
	     return factory.createMultipartConfig();  
	  }
}
