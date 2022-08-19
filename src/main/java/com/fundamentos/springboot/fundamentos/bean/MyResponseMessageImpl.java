package com.fundamentos.springboot.fundamentos.bean;

public class MyResponseMessageImpl implements MyResponseMessage{
    @Override
    public String response() {
        return "No quiero!!";
    }
}
