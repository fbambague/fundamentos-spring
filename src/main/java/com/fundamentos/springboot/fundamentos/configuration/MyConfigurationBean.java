package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

//  Implementación de MyBean
    @Bean
    public MyBean beanConfiguration(){
        return new MyBeanTwoImpl();
    }

    @Bean
    public MyOperation beanOperation(){
        return new MyOperationImpl();
    }

    @Bean
    public MyMessage message(){
        return new MyMessageImpl();
    }

    @Bean
    public MyResponseMessage responseMessage(){
        return new MyResponseMessageImpl();
    }

    @Bean
    public MyBeanWithDependency myBeanWithDependency(MyOperation myOperation, MyMessage myMessage, MyResponseMessage myResponseMessage){
        return new MyBeanWithDependencyImpl(myOperation, myMessage, myResponseMessage);
    }

}
