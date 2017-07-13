package ru.stqa.javacourse.sandbox;


public class FirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("Oleg");


        Point p1 = new Point(5.0, 9.0);
        Point p2 = new Point(7.0, 13.0);

        System.out.println("Дистанция между двумя точками равна:   " + p1.distance(p2));
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
        System.out.println(somebody + "," + "как дела");
    }


}