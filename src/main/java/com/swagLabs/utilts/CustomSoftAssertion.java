package com.swagLabs.utilts;


import org.testng.asserts.SoftAssert;

public class CustomSoftAssertion extends SoftAssert{

    public static CustomSoftAssertion softAssertion = new CustomSoftAssertion();

    public static void customAssertAll(){
       try {
           softAssertion.assertAll();
       }
       catch (Exception e){
           System.out.println("custom soft assertion failed");
       }

    }
}
