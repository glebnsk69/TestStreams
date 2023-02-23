import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("====================");
        ArrayList list = LoadWords("src/Words.txt");
        list.stream().forEach(System.out::println);
        Stream stream = list.stream();
//        System.out.println(stream.toString()+", "+stream.count());

        final Integer[] i = {0};
        stream.sorted().forEach(s-> System.out.println(++i[0] +":\t"+s));
        Stream stream2 = stream.sorted((o1, o2) -> o1.toString().length() > o2.toString().length());

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