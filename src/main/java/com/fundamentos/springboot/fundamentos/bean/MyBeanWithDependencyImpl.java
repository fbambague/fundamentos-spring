package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImpl.class);

    private MyOperation myOperation;
    private MyMessage myMessage;
    private MyResponseMessage myResponseMessage;

    public MyBeanWithDependencyImpl(MyOperation myOperation,MyMessage myMessage, MyResponseMessage myResponseMessage){
        this.myOperation = myOperation;
        this.myMessage = myMessage;
        this.myResponseMessage = myResponseMessage;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Entramos al metodo printWithDependency");
        int num1 = 2, num2 = 3;
//      EN PRODUCCIÓN EL NUVEL DEBUG SE DEBE APAGAR Y SOO TENER INFO
        LOGGER.debug("LOS números enviados como paramtero a la dependencia es: "+ num1 +" y "+num2);
        System.out.println("OPeration´s result: "+ myOperation.sum(num1,num2));
        System.out.println("Hi by a bean whit dependency");
        System.out.println("Message send by MyMessage: "+myMessage.sendMessage());
        System.out.println("Message response by MyResponseMessage: "+myResponseMessage.response());

    }
}
