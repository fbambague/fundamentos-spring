package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImpl implements MyBeanWithProperties{

    private String firstname;
    private String lastname;

    public MyBeanWithPropertiesImpl (String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }


    @Override
    public String function() {
        return firstname +" "+ lastname;
    }
}
