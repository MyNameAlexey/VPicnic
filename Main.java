package vpicnic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static vpicnic.IOFileConsole.*;
import static vpicnic.WordCount.getStringIntegerMap;
import static vpicnic.WordUnits.countWords;
import static vpicnic.WordUnits.findLongestWord;


public class Main {
    public static void main(String[] args) {
        String openFilePath = "input.txt";
        String exportFilePath = "export.txt";

        String text = null;
        try {
            text = readFile(openFilePath, StandardCharsets.UTF_8);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        String replaseText = "./?!,;:?U[pPs]-*•«»";
        text = text.toLowerCase().replace("\n", " ")
                .replace(",", " ")
                .replace(".", " ")
                .replace("  "," ")
                .replaceAll(replaseText, " ");

        String[] textArr = text.split(" ");

        System.out.println("Количество = " + countWords(textArr));
        System.out.println("Количество слов = " + textArr.length);
        System.out.println("Самое длинное слово = " + findLongestWord(textArr));

        Map<String, Integer> mapWords = getStringIntegerMap(textArr);
        System.out.println("Отсортированный пикник:");
        mapPrint(mapWords);


        WriteToFile(exportFilePath, mapWords);
    }




}
