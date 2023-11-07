package entity;

import java.util.Date;
import java.util.Objects;

public class History {
    private Book book;
    private Reader reader;
    private Date giveBookToReaderDate;
    private Date returnBook;

    public History() {
    }

    public History(Book book, Reader reader, Date giveBookToReaderDate, Date returnBook) {
        this.book = book;
        this.reader = reader;
        this.giveBookToReaderDate = giveBookToReaderDate;
        this.returnBook = returnBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getGiveBookToReaderDate() {
        return giveBookToReaderDate;
    }

    public void setGiveBookToReaderDate(Date giveBookToReaderDate) {
        this.giveBookToReaderDate = giveBookToReaderDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.book);
        hash = 17 * hash + Objects.hashCode(this.reader);
        hash = 17 * hash + Objects.hashCode(this.giveBookToReaderDate);
        hash = 17 * hash + Objects.hashCode(this.returnBook);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final History other = (History) obj;
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.giveBookToReaderDate, other.giveBookToReaderDate)) {
            return false;
        }
        if (!Objects.equals(this.returnBook, other.returnBook)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "History{" 
                + "book=" + book.getTitle()
                + ", reader=" + reader.getFirstname()
                + " " + reader.getLastname()
                + ", giveBookToReaderDate=" + giveBookToReaderDate 
                + ", returnBook=" + returnBook 
                + '}';
    }
    
    
}