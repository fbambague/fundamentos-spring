package com.fundamentos.springboot.fundamentos.component;

public class ComponentTwoImpl implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("Hola mundo componente 2");
    }
}
