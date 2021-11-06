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
        Pattern loginPattern = Pattern.compile("[a-zA-Z0-9]{1,10}");
        Pattern phonePattern = Pattern.compile("\\+38\\(0\\d{2}\\)\\d{2}[\\s|-]\\d{2}[\\s|-]\\d{3}");
        Pattern emailPattern = Pattern.compile("[a-zA-z]+\\d*@\\w+\\.\\w{2,3}");

        Scanner sc = new Scanner(System.in);
        Registration registration = new Registration();

        String userName = registration.newField("Введите логин", loginPattern);
        String userPhone = registration.newField("Введите номер телефона", phonePattern);
        String userEmail = registration.newField("Введите email", emailPattern);

        User user = new User(userName, userPhone, userEmail);
        System.out.println("Создан пользователь" + user);
    }
}



class User {
    private String userName;
    private String userPhone;
    private String userEmail;

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
            Matcher emailMatcher = pattern.matcher(text);
            if (emailMatcher.matches()) {
                return text;
            }
        }
    }
}
