package com.fundamentos.springboot.fundamentos.bean;

public class MyMessageImpl implements MyMessage{
    @Override
    public String sendMessage() {
        return "Llamame...";
    }
}
