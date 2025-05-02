package com.librarysystem.data;

import com.librarysystem.model.Book;
import com.librarysystem.model.Staff;
import com.librarysystem.model.Student;
import com.librarysystem.service.LibraryService;

public class FakeDataLoader {
    public static void load(LibraryService libraryService) {
        libraryService.addBook(new Book(1, "Suç ve Ceza", "Dostoyevski", "Klasik"));
        libraryService.addBook(new Book(2, "Sefiller", "Victor Hugo", "Roman"));
        libraryService.addBook(new Book(3, "Kürk Mantolu Madonna", "Sabahattin Ali", "Türk Edebiyatı"));

        libraryService.addUser(new Student(101, "Ali Öğrenci"));
        libraryService.addUser(new Staff(102, "Ayşe Personel"));
    }
}
