package ru.stqa.javacourse.mantis.tests;


import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class IgnoredTest extends TestBase{

    private int id=1;


    @Test
    public void testIgnored() throws RemoteException, ServiceException, MalformedURLException {
        skipIfNotFixed(id);
        System.out.println("Test is enabled");
    }

}

