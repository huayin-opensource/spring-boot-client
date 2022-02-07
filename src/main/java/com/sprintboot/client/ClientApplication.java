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
		log.info("当前服务实例名称：{}",System.getenv("SERVICE_NAME"));
		initZkConnection()
	}

	/**
	 * 初始化 zk 链接
	 * @throws Exception
	 */
	protected void initZkConnection() throws Exception {
		RetryPolicy retryPolicy = new RetryForever(1000);
		List<String> zkAddress = getDasZk(platformServiceConfig.getServiceName(),
				platformServiceConfig.getBenchmarkEnv());

		String nameSpace = getDasPlatformNameSpace(platformServiceConfig.getServiceEnv());
		log.info("initZkConnection() zkAddress={}, nameSpace={}", zkAddress, nameSpace);
		this.curatorFramework = CuratorFrameworkFactory.builder()
				.connectString(zkAddress.get(0))
				.retryPolicy(retryPolicy)
				.sessionTimeoutMs(SESSION_TIME)  // 120s
				.connectionTimeoutMs(CONNECT_TIMEOUT)  // 100s
				.namespace(nameSpace)
				.build();
		this.curatorFramework.start();
		this.curatorFramework.blockUntilConnected(10, TimeUnit.SECONDS);
	}
}
