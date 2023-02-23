import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("====================");
        ArrayList list = LoadWords("src/Words.txt");  //загружаю список имен из файлв
        ArrayList<User>userList = new ArrayList<User>();
        for (int i = 0; i < list.size(); i++) { //заполняю список классов юзер именами и номером по порядку
            String str = (String) list.get(i);
            userList.add(new User(str,i));
        }
//        проверяю что получилось
        userList.stream().forEach(o-> System.out.println(o.getNumber()+":"+o.getName()));
// сортирую по длинне и вывожу отсортированое
        userList.stream()
                .sorted((o1, o2) -> o1.getName().length()-o2.getName().length())
                .forEach(System.out::println);
// сортирую по алфавиту и вывожу
        userList.stream()
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(System.out::println);

        System.out.println("сортирую и вывожу только на А");
        userList.stream()
                .filter(user -> user.getName().matches("^А.*"))
                .sorted((o1, o2) ->o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(System.out::println);
        System.out.println("===========================");
        System.out.println("вывожу только на А");
        userList.stream()
                .filter(user -> user.getName().matches("^А.*"))
                .forEach(System.out::println);
        System.out.println("===========================");






//        list.stream().forEach(System.out::println);
//        Stream stream = list.stream();
//        System.out.println(stream.toString()+", "+stream.count());
//
//        final Integer[] i = {0};
//        stream.sorted().forEach(s-> System.out.println(++i[0] +":\t"+s));
//        Stream stream2 = stream.filter(o -> )
//                Stream stream3 = stream.sorted((o1, o2) -> o1.toString().length() - o2.toString().length());
//        stream2.forEach(System.out::println);



    }

    public static ArrayList<String> LoadWords(String name) throws IOException {
        Scanner scanner;
        ArrayList<String> list = new ArrayList<String>();
        try {
            scanner = new Scanner(Paths.get(name));
        } catch (IOException e) {
            throw new IOException(e);
        }
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        scanner.close();
        return list;
    }

}