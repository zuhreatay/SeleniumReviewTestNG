package com.techproed.tests;

import org.testng.annotations.Test;

public class DepentsOnMethodsTest {


    @Test
    public void test01(){
        System.out.println("test01");
    }

    @Test (dependsOnMethods = "test01")
    public void test02(){
        System.out.println("test02");
    }
}
