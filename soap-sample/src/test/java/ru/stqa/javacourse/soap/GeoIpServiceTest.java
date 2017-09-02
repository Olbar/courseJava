package ru.stqa.javacourse.soap;


import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class GeoIpServiceTest {

   @Test
    public void testMyIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("194.28.29.52");
       assertEquals(geoIP.getCountryCode(), "RUS");
    }
}
