package extra;

/*
* Задание
* Напишите консольное приложение, позволяющие пользователю зарегистрироваться под «Логином»,
* состоящем только из символов латинского алфавита, и пароля, состоящего из цифр и символов.
* */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extra {
    public static void main(String[] args) {
        Pattern loginPattern = Pattern.compile("[a-zA-Z]{4,}");
        Pattern passPattern = Pattern.compile("[a-zA-Z0-9]{6,}");

        User user = new User(
                Registration.newField("Введите логин (от 4 символов):", loginPattern),
                Registration.newField("Введите пароль (допускается латиница и цифры, от 6 символов):", passPattern)
        );

        System.out.println("Создан пользователь" + user);
    }
}

class User {
    private final String userName;
    private final String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}

class Registration {
    public static String newField(String message, Pattern pattern) {
        while (true) {
            System.out.println(message);
            String input = new Scanner(System.in).nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return input;
            }
        }
    }
}
