package com.microservices.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservices.userservice.model.User;
import com.microservices.userservice.repository.UserRepository;

@SpringBootApplication
public class UserInfoServiceStarter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserInfoServiceStarter.class, args);
    }

  /*
   * TODO : Data can be inserted either through commandliner, data.sql, 
   *  @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepo)
    {
	  return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				 userRepo.save(new User( "lala", "123", "ymail"));
				   userRepo.save(new User( "lala", "123", "ymail"));
				   userRepo.save(new User( "lala", "123", "ymail"));
							
			}
		};
    	
    }
    @Bean(name = "dataSource")
public DriverManagerDataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:~/myDB;MV_STORE=false");
    dataSource.setUsername("sa");
    dataSource.setPassword("");

    // schema init
    Resource initSchema = new ClassPathResource("scripts/schema-h2.sql");
    Resource initData = new ClassPathResource("scripts/data-h2.sql");
    DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
    DatabasePopulatorUtils.execute(databasePopulator, dataSource);

    return dataSource;
}
    *
    */
}