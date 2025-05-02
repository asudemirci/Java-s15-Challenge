package com.librarysystem.service;

import com.librarysystem.model.Book;
import com.librarysystem.model.Invoice;
import com.librarysystem.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private Map<Integer, Book> books;
    private Map<Integer, User> users;
    private Map<Book, User> loans;
    private List<Invoice> invoices;

    public LibraryService() {
        books = new HashMap<>();
        users = new HashMap<>();
        loans = new HashMap<>();
        this.invoices = new ArrayList<>();

    }
    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Kitap eklendi: " + book);
    }
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Hiç kitap yok.");
            return;
        }
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
    public Book getBookById(int id) {
        return books.get(id);
    }
    public void addUser(User user) {
        users.put(user.getId(), user);
        System.out.println("Kullanıcı eklendi: " + user.getName() + " (" + user.getUserType() + ")");
    }
    public void borrowBook(int userId, int bookId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null) {
            System.out.println("Kitap bulunamadı.");
            return;
        }
        if (user == null) {
            System.out.println("Kullanıcı bulunamadı.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Kitap şu anda başkasında.");
            return;
        }
        if (user.hasReachedLimit()) {
            System.out.println("Kullanıcı zaten 5 kitap almış.");
            return;
        }

        book.setAvailable(false);
        user.borrowBook(book);
        loans.put(book, user);
        System.out.println(user.getName() + " kitabı aldı: " + book.getTitle());

        Invoice invoice = new Invoice(userId, bookId);
        invoice.printInvoice();
        invoices.add(invoice);
    }
    public void returnBook(int userId, int bookId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null || user == null) {
            System.out.println("Kitap veya kullanıcı bulunamadı.");
            return;
        }

        if (!user.hasBook(book)) {
            System.out.println("Bu kitap bu kullanıcıda değil.");
            return;
        }

        book.setAvailable(true);
        user.returnBook(book);
        loans.remove(book);
        System.out.println(user.getName() + " kitabı iade etti: " + book.getTitle());

        for (Invoice invoice : invoices) {
            if (invoice != null && invoice.getBookId() == bookId && invoice.getUserId() == userId) {
                invoice.refund();
                break;
            }
        }
    }
    public void listBooksByAuthor(String author) {
        books.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }
    public void listBooksByCategory(String category) {
        books.values().stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .forEach(System.out::println);
    }
}
