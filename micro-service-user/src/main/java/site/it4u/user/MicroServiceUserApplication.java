package site.it4u.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceUserApplication.class, args);
	}
}
