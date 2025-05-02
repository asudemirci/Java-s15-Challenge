package com.librarysystem.app;

import com.librarysystem.data.FakeDataLoader;
import com.librarysystem.model.Book;
import com.librarysystem.model.Staff;
import com.librarysystem.model.Student;
import com.librarysystem.service.LibraryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        FakeDataLoader.load(libraryService);


        boolean running = true;
        while (running) {
        System.out.println("\n📚 KÜTÜPHANE SİSTEMİ");
        System.out.println("1. Kitap Ekle");
        System.out.println("2. Tüm Kitapları Listele");
        System.out.println("3. Kitap Ödünç Al");
        System.out.println("4. Kitap İade Et");
        System.out.println("5. Yazara Göre Listele");
        System.out.println("6. Kategoriye Göre Listele");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminiz: ");
        int secim = scanner.nextInt();
        scanner.nextLine();
        switch (secim) {
            case 1:
                System.out.print("Kitap ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Başlık: ");
                String title = scanner.nextLine();
                System.out.print("Yazar: ");
                String author = scanner.nextLine();
                System.out.print("Kategori: ");
                String category = scanner.nextLine();
                Book book = new Book(id, title, author, category);
                libraryService.addBook(book);
                break;
            case 2:
                libraryService.listBooks();
                break;
            case 3:
                System.out.print("Kullanıcı ID: ");
                int uid = scanner.nextInt();
                System.out.print("Kitap ID: ");
                int bid = scanner.nextInt();
                libraryService.borrowBook(uid, bid);
                break;
            case 4:
                System.out.print("Kullanıcı ID: ");
                int uidR = scanner.nextInt();
                System.out.print("Kitap ID: ");
                int bidR = scanner.nextInt();
                libraryService.returnBook(uidR, bidR);
                break;
            case 5:
                System.out.print("Yazar: ");
                String a = scanner.nextLine();
                libraryService.listBooksByAuthor(a);
                break;
            case 6:
                System.out.print("Kategori: ");
                String c = scanner.nextLine();
                libraryService.listBooksByCategory(c);
                break;
            case 0:
                running = false;
                System.out.println("Sistemden çıkılıyor...");
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }
    }

        scanner.close();
}
}
