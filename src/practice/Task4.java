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
        Pattern login = Pattern.compile("[a-zA-Z0-9]{1,10}");
        Pattern phone = Pattern.compile("\\+38\\(0\\d{2}\\)\\d{2}[\\s|-]\\d{2}[\\s|-]\\d{3}");
        Pattern email = Pattern.compile("\\w+@\\w+\\.\\w{2,3}");

        Scanner sc = new Scanner(System.in);

        String userName;
        String userPhone;
        String userEmail;

        while (true) {
            System.out.println("Введите имя пользователя:");
            String loginInput = sc.nextLine();
            Matcher loginMatcher = login.matcher(loginInput);
            if (!loginMatcher.matches())
                System.out.println("Некорректный логин, введите еще раз");
            else {
                userName = loginInput;
                break;
            }
        }

        while (true) {
            System.out.println("Введите номер телефона:");
            String phoneInput = sc.nextLine();
            Matcher phoneMatcher = phone.matcher(phoneInput);
            if (!phoneMatcher.matches())
                System.out.println("Некорректный номер телефона, введите еще раз");
            else {
                userPhone = phoneInput;
                break;
            }
        }

        while (true) {
            System.out.println("Введите email:");
            String emailInput = sc.nextLine();
            Matcher emailMatcher = email.matcher(emailInput);
            if (!emailMatcher.matches())
                System.out.println("Некорректный email, введите еще раз");
            else {
                userEmail = emailInput;
                break;
            }
        }

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
