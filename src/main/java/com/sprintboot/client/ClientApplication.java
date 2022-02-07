package com.sprintboot.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) throws ClassNotFoundException {
		SpringApplication.run(ClientApplication.class, args);
		log.info("client服务实例 start");
		// client实例初始化
		String[] m= {"1","233","21","3","21"};
		log.info("当前服务实例名称：{}",System.getenv("SERVICE_NAME"));
		log.info("mmmm",m);
	}
}

