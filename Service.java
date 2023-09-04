package Homework;

public class Service {

    /**
     * @param info данные, которые ввел пользователь String
     * @return код ошибки
     * @apiNote метод проверяет соответствует ли размер вводимой информации ожидаемому, если не соответствует,
     * то выбрасывает код ошибки
     */
    int errorSize(String[] info) {
        if (info.length < 6) {
            return 1;
        } else if (info.length > 6) {
            return 2;
        }
        return 0;
    }

    /**
     * @param code код ошибки полученный из метода errorSize
     * @apiNote метод расшифровывает код ошибки
     */
    void errorInfo(int code) {
        if (code == 1) {
            System.out.println("Количество данных меньше ожидаемого!");
            System.exit(0);
        } else if (code == 2) {
            System.out.println("Количество данных больше ожидаемого!");
            System.exit(0);
        }
    }

    /**
     * @param info данные, которые ввел пользователь String
     * @apiNote проверяет соответствует ли ввобидмая информация полу, если не соответсвует,
     * то выбрасывается RuntimeException
     */
    void parseGender(String[] info) {
        if (info[5].equals("f") || info[5].equals("m")) {
        } else {
            throw new RuntimeException("Пол введен неправильно! ");
        }
    }

    /**
     * @param info данные, которые ввел пользователь String
     * @return отсортированный массив
     * @apiNote проверяет соответсвует ли ввобидмая информация номеру телефона, если не соответсвует,
     * то выбрасывается RuntimeException. Если соответсвует, о меняет местами данные в массиве
     */
    String[] parseNumber(String[] info) {
        for (int i = 4; i < info.length; i++) {
            if (info[i].matches("[0-9]+")) {
                String number = info[i];
                info[i] = info[4];
                info[4] = number;
                return info;
            }
        }
        throw new RuntimeException("Номер телефона введен неправильно! ");
    }

    /**
     * @param info данные, которые ввел пользователь String
     * @return отсортированный массив
     * @apiNote проверяет соответсвует ли ввобидмая информация дате рождения, если не соответсвует,
     * то выбрасывается RuntimeException. Если соответсвует, о меняет местами данные в массиве
     */
    String[] parseData(String[] info) {
        for (int i = 3; i < info.length; i++) {
            if (info[i].matches("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)")) {
                String data = info[i];
                info[i] = info[3];
                info[3] = data;
                return info;
            }
        }
        throw new RuntimeException("Дата рождения введена неправильно! ");
    }

    /**
     * @param info данные, которые ввел пользователь String
     * @return отсортированный массив
     * @apiNote проверяет соответсвует ли ввобидмая информация Фамилии Имени Отчеству, если не соответсвует,
     * то выбрасывается RuntimeException. Если соответсвует, о меняет местами данные в массиве
     */
    String[] parseFio(String[] info) {
        for (int i = 0; i < info.length; i++) {
            if (info[i].matches("[а-я]+")) {
                String surname = info[i];
                info[i] = info[0];
                info[0] = surname;
                for (int j = 1; j < info.length; j++) {
                    if (info[j].matches("[а-я]+")) {
                        String name = info[j];
                        info[j] = info[1];
                        info[1] = name;
                        for (int k = 2; k < info.length; k++) {
                            if (info[k].matches("[а-я]+")) {
                                String patron = info[k];
                                info[k] = info[2];
                                info[2] = patron;
                                return info;
                            }
                        }
                        throw new RuntimeException("Отчество введено неправильно");
                    }
                }
                throw new RuntimeException("Имя введено неправильно");
            }
        }
        throw new RuntimeException("Фамилия введена неправильно");
    }
}

