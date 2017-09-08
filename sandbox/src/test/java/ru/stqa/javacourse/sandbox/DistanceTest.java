package ru.stqa.javacourse.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {

    @Test
    public void testDistance(){
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(4.0, 3.0);
        Assert.assertEquals(p2.distance(p1),6.0);
    }
}
