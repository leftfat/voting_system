package tw.taipei.scteam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.password4j.AlgorithmFinder;
import com.password4j.Argon2Function;

@Configuration
public class ServiceConfig {

  @Bean
  public Argon2Function argon2Function() {
    return AlgorithmFinder.getArgon2Instance();
  }
}
