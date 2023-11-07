package jptv22library;

import entity.History;
import managers.HistoryManager;
import entity.Book;
import entity.Reader;
import java.util.Arrays;
import managers.BookManager;
import managers.ReaderManager;
import java.util.Scanner;
import managers.SaveManager;
import tools.InputFromKeyboard;

public class App {
    private final Scanner scanner;
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private HistoryManager historyManager;
    private SaveManager saveManager;
    
    public App() {
        this.scanner = new Scanner(System.in);
        this.saveManager = new SaveManager();
        this.books = saveManager.loadBooks();//инициализация поля books и сюда считаем инфу из файла
        this.readers = saveManager.loadReaders();
        this.histories = saveManager.loadHistories();
        this.bookManager = new BookManager(scanner);
        this.readerManager = new ReaderManager(scanner);
        this.historyManager = new HistoryManager(scanner);
    }
    
    
    
    
    void run() {
        boolean repeat = true;
        System.out.println("------ Library ------");
        do{
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add new book");
            System.out.println("2. Add new reader");
            System.out.println("3. Print list books");
            System.out.println("4. Print list readers");
            System.out.println("5. Give the book to the reader");
            System.out.println("6. Return book");
            System.out.println("7. Print list readed books");
            System.out.print("Enter number task: ");
            int task = InputFromKeyboard.inputNumberFromRange(0,7);
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    addBookToBooks(bookManager.addBook());
                    break;
                case 2:
                    addReaderToReaders(readerManager.addReader());
                    break;
                case 3:
                    bookManager.pirntListBooks(books);
                    break;
                case 4:
                    readerManager.pirntListReaders(readers);
                    break;
                case 5:
                    History history = historyManager.giveBookToReader(readers, books);
                    if(history != null){
                        addHistoryToHistories(history);
                    }
                    break;
                    
                case 6:
                    historyManager.returnBook(histories);
                    saveManager.saveHistories(histories);
                    break;
                case 7:
                    historyManager.printListReadingBooks(histories);
                    break;
                default:
                    System.out.println("Select number from list tasks!");
            }
        }while(repeat);
    }

    private void addBookToBooks(Book book) {
        this.books = Arrays.copyOf(this.books, this.books.length + 1);
        this.books[this.books.length - 1] = book;
        saveManager.saveBooks(this.books);//save to file
    }

    private void addReaderToReaders(Reader reader) {
        this.readers = Arrays.copyOf(this.readers, this.readers.length + 1);
        this.readers[this.readers.length - 1] = reader;
        saveManager.saveReaders(this.readers);
        
    }
    private void addHistoryToHistories(History history) {
        this.histories = Arrays.copyOf(this.histories, this.histories.length + 1);
        this.histories[this.histories.length - 1] = history;
    }

    
    
}