package practice;

/*
* Задание 4
Напишите регулярные выражения, которые бы проверяли корректность введенных пользователем полей.
Для регистрации в приложении поля должны соответствовать таким требованиям:
логин - не более 10 символов большими или маленькими буквами
номер телефона - иметь шаблон +38(098)77 88 999 или +38(098)77-88-999
email - на ваше усмотрение
* */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        Registration registration = new Registration();

        Pattern loginPattern = Pattern.compile("[a-zA-Z0-9]{1,10}");
        Pattern phonePattern = Pattern.compile("\\+38\\(0\\d{2}\\)\\d{2}[\\s|-]\\d{2}[\\s|-]\\d{3}");
        Pattern emailPattern = Pattern.compile("[a-zA-z]+\\d*@\\w+\\.\\w{2,3}");

        User user = new User(
                registration.newField("Введите логин", loginPattern),
                registration.newField("Введите номер телефона", phonePattern),
                registration.newField("Введите email", emailPattern)
        );

        System.out.println("Создан пользователь" + user);
    }
}



class User {
    private final String userName;
    private final String userPhone;
    private final String userEmail;

    public User(String userName, String userPhone, String userEmail) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}

class Registration {
    public String newField(String message, Pattern pattern) {
        while (true) {
            System.out.println(message);
            String text = new Scanner(System.in).nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()) {
                return text;
            }
        }
    }
}
