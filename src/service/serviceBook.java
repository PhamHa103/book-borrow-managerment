package service;

import entity.Book;

import java.util.Scanner;

public class serviceBook {
    private static Book[] BOOKS = new Book[100];

    // 3. Tạo đầu sách mới
    public static void inputBook() {
        System.out.print("Số lượng đầu sách bạn muốn nhập: ");
        int bookNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < bookNumber; i++) {
            Book book = new Book();
            System.out.println("Xin mời nhập thông tin của đầu sách thứ " + (i + 1));
            book.inputInfor();
            saveBook(book);
        }
    }

    private static void saveBook(Book book) {
        for (int i = 0; i < BOOKS.length; i++) {
            if (BOOKS[i] == null) {
                BOOKS[i] = book;
                break;
            }
        }

    }

    //4. In ra danh sách đầu sách trong hệ thống
    public static void showBook() {
        System.out.println("--------------------------------------");
        if (isEmptyBook()) {
            System.out.println("Chưa có thông tin đầu sách nào trong hệ thống, xin mời nhập thông tin đầu sách!");
            return;
        }
        System.out.println("Danh sách đầu sách có trông hệ thống:");
        for (int i = 0; i < BOOKS.length; i++) {
            if (BOOKS[i] != null)
                System.out.println(BOOKS[i]);
        }
    }

    private static boolean isEmptyBook() {
        for (int i = 0; i < BOOKS.length; i++) {
            if (BOOKS[i] != null)
                return false;
        }
        return true;
    }


    //
    public static Book creatBookOfOrderDetail() {
        System.out.print("Xin mời nhập ID đầu sách muốn mượn: ");
        int idBook = 0;
        while (true) {
            idBook = new Scanner(System.in).nextInt();
            if (hasBook(idBook))
                break;
            System.out.print("Địa chỉ ID đầu sách không tồn tại trong hệ thống, xin mời nhập lại: ");
        }
        Book book = getBook(idBook);
        return book;
    }

    private static Book getBook(int idBook) {
        Book book = new Book();
        for (int j = 0; j < BOOKS.length; j++) {
            if (BOOKS[j] != null && BOOKS[j].getId() == idBook)
                book = BOOKS[j];
        }
        return book;
    }

    private static boolean hasBook(int idBook) {
        for (int i = 0; i < BOOKS.length; i++) {
            if (BOOKS[i] != null && BOOKS[i].getId() == idBook)
                return true;
        }
        return false;
    }
}
