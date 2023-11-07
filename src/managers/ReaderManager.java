package managers;

import entity.Reader;
import java.util.Scanner;

public class ReaderManager {

    private final Scanner scanner;

    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Reader addReader() {
        System.out.println(" ----- Add new reader -----");
        Reader reader = new Reader();
        System.out.print("Firstname: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Lastname: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Phone: ");
        reader.setPhone(scanner.nextLine());
        System.out.println("Added reader " + reader.toString());
        return reader;
    }

    public int pirntListReaders(Reader[] readers) {
        int count = 0;
        System.out.println("List readers: ");
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s. %s. %s%n",
                    i+1,
                    readers[i].getFirstname(),
                    readers[i].getLastname(),
                    readers[i].getPhone()
            );
            count++;
        }
        return count;
    }
    
    
}