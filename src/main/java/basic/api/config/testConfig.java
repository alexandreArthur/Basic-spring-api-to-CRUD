package basic.api.config;

import basic.api.services.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
public class testConfig {
    @Autowired
    private dbService dbService;

    @Bean
    public boolean instatianteDataBase() throws ParseException {
        dbService.instantiateTestDataBase();
        return true;
    }
}
