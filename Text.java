package Homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;

public class Text {

    /**
     * @param info данные, которые ввел пользователь String
     * @throws IOException ошибка при работе с файлом
     * @apiNote создает и записывает данные в файл txt по фамилии
     */
    void writeFile(String[] info) throws IOException {
        String fileName = info[0] + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.length() > 0) {
                fileWriter.write('\n');
                fileWriter.write(String.format("%s %s %s %s %s %s", info[0], info[1], info[2], info[3], info[4],
                        info[5]));
            } else {
                fileWriter.write(String.format("%s %s %s %s %s %s", info[0], info[1], info[2], info[3], info[4],
                        info[5]));
            }
        } catch (IOException e) {
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }
    }
}

