package practice;

/*
* Задание 3
Дана строка “Versions: Java  5, Java 6, Java   7, Java 8.”  Найти все подстроки "Java X" и распечатать их.
* */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String str = "Versions: Java  5, Java 6, Java   7, Java 8.";

        Pattern pattern = Pattern.compile("(Java)( +)(\\d)");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
