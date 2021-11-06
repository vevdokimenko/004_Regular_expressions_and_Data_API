package practice;

/*
* Задание 2
Дана строка 'aa aba abba abbba abca abea'. Напишите регулярное выражение, которая найдет строки aa, aba, abba, abbba по
шаблону: буква 'a', буква 'b' любое количество раз (в том числе ниодного раза), буква 'a'. Выведите строки на консоль
* */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String str = "aa aba abba abbba abca abea";

        Pattern pattern = Pattern.compile("(a)(b*)(a)");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
