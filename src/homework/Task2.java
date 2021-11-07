package homework;

/*
* Задание 2
* Напишите шуточную программу «Дешифратор», которая бы в текстовом файле могла бы заменить все предлоги на слово «Java».
* */

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        Pattern patternPretext = Pattern.compile(
                "(\\r|\\s)(в|без|до|для|за|через|над|по|из|у|около|под|о|про|на|к|перед|при|с|между)(\\s)",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.MULTILINE);
        String replaceTo = "$1Java$3";

        StringBuilder content = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader("./src/homework/text.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("./src/homework/textOut.txt"))
        ) {
            int num;
            while ((num = reader.read()) != -1) {
                content.append((char) num);
            }

            Matcher matcher = patternPretext.matcher(content.toString());

            if (matcher.find()) {
                content = new StringBuilder(matcher.replaceAll(replaceTo));
            }

            writer.write(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
