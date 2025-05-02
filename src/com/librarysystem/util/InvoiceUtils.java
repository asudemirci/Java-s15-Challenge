package com.librarysystem.util;

import com.librarysystem.model.Invoice;

public class InvoiceUtils {
    public static void printDetailedInvoice(Invoice invoice) {
        System.out.println("=========== FATURA DETAYI ===========");
        invoice.printInvoice();
        System.out.println("=====================================");
    }
}
