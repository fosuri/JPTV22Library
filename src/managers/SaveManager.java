package managers;

import entity.Book;
import entity.Reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveManager {
    public void saveBooks(Book[] books){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("books");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
        
    }
    public Book[] loadBooks(){
        Book[] books = new Book[0];
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("books");
            ois = new ObjectInputStream(fis);
            books = (Book[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return books;
    }

    public void saveReaders(Reader[] readers){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("readers");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
    }

    public Reader[] loadReaders(){
        Reader[] readers = new Reader[0];
        FileInputStream fis;
        ObjectInputStream  ois;
        try {
            fis = new FileInputStream("readers");
            ois = new ObjectInputStream(fis);
            readers = (Reader[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return readers;
    }
}