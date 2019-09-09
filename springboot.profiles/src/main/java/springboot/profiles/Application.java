package springboot.profiles;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springboot.profiles.config.EnvBasedConfig;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private EnvBasedConfig envBasedConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("\nDatasource = " + dataSource.getLogWriter());
		System.out.println("\n\nDatasource Connection = " + dataSource.getConnection());
		System.out.println("Datasource Class = " + dataSource.getClass());
		
		envBasedConfig.setup();
	}

}
