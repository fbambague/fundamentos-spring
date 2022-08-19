package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.caseUse.GetUser;
import com.fundamentos.springboot.fundamentos.caseUse.GetUserImpl;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    public GetUser getUser(UserService userService){
        return new GetUserImpl(userService);
    }


}
