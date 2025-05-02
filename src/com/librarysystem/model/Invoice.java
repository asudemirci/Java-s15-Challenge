package com.librarysystem.model;

public class Invoice {
    private static final double PRICE_PER_BOOK = 10.0;

    private int userId;
    private int bookId;
    private double total;
    private boolean refunded;

    public Invoice(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.total = PRICE_PER_BOOK;
        this.refunded = false;
    }

    public void refund() {
        if (!refunded) {
            refunded = true;
            System.out.println("💸 " + total + " TL iade edildi (Kullanıcı ID: " + userId + ")");
        } else {
            System.out.println("Zaten iade edilmiş.");
        }
    }

    public void printInvoice() {
        System.out.println("🧾 Fatura - Kullanıcı ID: " + userId + ", Kitap ID: " + bookId + ", Tutar: " + total + " TL");
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }
}
