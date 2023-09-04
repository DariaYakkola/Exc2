package Homework;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service serv = new Service();
        Text file = new Text();
        System.out.println("Введите данные через пробел: Фамилию Имя Отчество, дату рождения, номер телефона, пол");
        String info = sc.nextLine().toLowerCase();
        String[] data = info.split(" ");
        int result = serv.errorSize(data);
        serv.errorInfo(result);
        serv.parseFio(data);
        serv.parseData(data);
        serv.parseNumber(data);
        serv.parseGender(data);
        try {
            file.writeFile(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}