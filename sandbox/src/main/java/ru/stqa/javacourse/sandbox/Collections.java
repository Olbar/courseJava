package ru.stqa.javacourse.sandbox;



import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String arg[]) {

        List<String> languages = Arrays.asList("JAVA","C#","Python","PHP");

        for (String l : languages){
            System.out.println("Я хочу выучить язык" + l);
        }
    }
}
