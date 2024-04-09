package vpicnic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static vpicnic.WordCount.entriesSortedByValues;

public abstract class IOFileConsole {
    /**
     * Чтение файла
     *
     * @param path
     * @param encoding
     * @return
     * @throws IOException
     */

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Print map
     *
     * @param mapWords
     */
    public static void mapPrint(Map<String, Integer> mapWords) {
        for (Map.Entry<String, Integer> elem : entriesSortedByValues(mapWords)) {
            System.out.println(elem);
        }
    }
    public static String getString(String openFilePath) {
        String text = null;
        try {
            text = readFile(openFilePath, StandardCharsets.UTF_8);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return text;
    }
    public static void WriteToFile(String exportFilePath, Map<String, Integer> mapWords) {
        try (PrintWriter out = new PrintWriter(exportFilePath)) {
            for (Map.Entry<String, Integer> elem : entriesSortedByValues(mapWords)) {

                out.println(elem);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}