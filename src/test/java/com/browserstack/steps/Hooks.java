package com.browserstack.steps;

import io.cucumber.java.*;

public class Hooks {

    @Before
    public void before(Scenario scenario){
        System.out.println();
        System.out.println("Before : "+scenario.getName()+"Status : "+scenario.getStatus());
        System.out.println("Id : " +scenario.getId());
        System.out.println("Name : " +scenario.getName());
        System.out.println("Status : " +scenario.getStatus());
        System.out.println("Line : " +scenario.getLine());
        System.out.println("Tags : " +scenario.getSourceTagNames());
        System.out.println("URI : " +scenario.getUri());
        System.out.println();
    }

    @After
    public void after(Scenario scenario){
        System.out.println();
        System.out.println("After : "+scenario);
        System.out.println("Before : "+scenario.getName()+"Status : "+scenario.getStatus());
        System.out.println("Id : " +scenario.getId());
        System.out.println("Name : " +scenario.getName());
        System.out.println("Status : " +scenario.getStatus());
        System.out.println("Line : " +scenario.getLine());
        System.out.println("Tags : " +scenario.getSourceTagNames());
        System.out.println("URI : " +scenario.getUri());
        System.out.println();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){
        System.out.println();
        System.out.println("BeforeStep : "+scenario);
        System.out.println("Before : "+scenario.getName()+"Status : "+scenario.getStatus());
        System.out.println("Id : " +scenario.getId());
        System.out.println("Name : " +scenario.getName());
        System.out.println("Status : " +scenario.getStatus());
        System.out.println("Line : " +scenario.getLine());
        System.out.println("Tags : " +scenario.getSourceTagNames());
        System.out.println("URI : " +scenario.getUri());
        System.out.println();
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        System.out.println();
        System.out.println("AfterStep : "+scenario);
        System.out.println("Before : "+scenario.getName()+"Status : "+scenario.getStatus());
        System.out.println("Id : " +scenario.getId());
        System.out.println("Name : " +scenario.getName());
        System.out.println("Status : " +scenario.getStatus());
        System.out.println("Line : " +scenario.getLine());
        System.out.println("Tags : " +scenario.getSourceTagNames());
        System.out.println("URI : " +scenario.getUri());
        System.out.println();
    }

}
