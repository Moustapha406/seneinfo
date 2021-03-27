package com.sene.info;

import com.sene.info.controller.ClientController;

public class App {
    public static void main( String[] args )
    {
        System.out.println("hello");
        ClientController clientController=new ClientController();
        clientController.proccess();
    }
}
