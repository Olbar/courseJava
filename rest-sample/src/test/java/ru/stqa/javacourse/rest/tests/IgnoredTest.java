package ru.stqa.javacourse.rest.tests;


import org.testng.annotations.Test;


public class IgnoredTest extends TestBase{

    private int id=5;


    @Test
    public void testIgnored(){
        skipIfNotFixed(id);
        System.out.println("Test is enabled");
    }

}

