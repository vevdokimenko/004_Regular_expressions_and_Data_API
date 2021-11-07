package homework;

/*
 * Задание 3
 * Спроектируйте и разработайте метод, определяющий, сколько времени прошло с заданной даты.
 * С помощью этого методы выведите в консоль, сколько времени прошло с вашего дня рождения
 * в удобном для восприятия виде, например: «Вам исполнилось 20 лет, 3 месяца, 18 дней, 4 часа, 5 минут и 10 секунд».
 * */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Task3 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate birthday = LocalDate.of(1985, 10, 23);

        Period period = Period.between(birthday, LocalDate.from(now));

        System.out.printf(
                "Вам исполнилось %d %s, %d месяц%s, %d %s, %d час%s, %d минут%s и %d секунд%s",
                period.getYears(),
                getStringYear(period.getYears()),
                period.getMonths(),
                getStringMonth(period.getMonths()),
                period.getDays(),
                getStringDay(period.getDays()),
                now.getHour(),
                getStringHours(now.getHour()),
                now.getMinute(),
                getStringMinSec(now.getMinute()),
                now.getSecond(),
                getStringMinSec(now.getSecond())
        );
    }

    private static String getStringYear(int year) {
        if (year >= 10 && year <= 20) return "лет";
        return switch (year % 10) {
            case 1 -> "год";
            case 2, 3, 4 -> "года";
            default -> "лет";
        };
    }

    private static String getStringMonth(int month) {
        return switch (month) {
            case 1 -> "";
            case 2, 3, 4 -> "а";
            default -> "ев";
        };
    }

    private static String getStringDay(int day) {
        if (day >= 10 && day <= 20) return "дней";
        return switch (day % 10) {
            case 1 -> "день";
            case 2, 3, 4 -> "дня";
            default -> "дней";
        };
    }

    private static String getStringHours(int hours) {
        if (hours >= 10 && hours <= 20) return "ов";
        return switch (hours % 10) {
            case 1 -> "";
            case 2, 3, 4 -> "а";
            default -> "ов";
        };
    }

    private static String getStringMinSec(int minSec) {
        if (minSec >= 10 && minSec <= 20) return "";
        return switch (minSec % 10) {
            case 1 -> "а";
            case 2, 3, 4 -> "ы";
            default -> "";
        };
    }
}
