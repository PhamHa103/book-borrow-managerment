package service;

import entity.Book;
import entity.OrderBook;
import entity.OrderBookDetail;
import entity.Reader;

import java.util.Scanner;

import static service.serviceBook.creatBookOfOrderDetail;
import static service.serviceReader.creatReaderOfOrder;

public class serviceOrder {

    public static OrderBook[] ORDERS = new OrderBook[100];

    //5.1 Tạo ra danh sách quản lý mượn sách
    public static void creatLibrary() {
        System.out.print("Xin mời nhập số lượng bạn đọc muốn mượn sách: ");
        int readerBorrowBookNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerBorrowBookNumber; i++) {
            System.out.println("Xin mời nhập thông tin mượn sách của bạn đọc thứ " + (i + 1));
            saveOrderToLibrary(creatOneOrder());
        }

    }

    public static OrderBook creatOneOrder() {
        // Tạo một reader
        Reader reader = creatReaderOfOrder();
        //Tạo 1 mảng orderBookDetail
        OrderBookDetail[] ORDER_BOOK_DETAILS = new OrderBookDetail[100];
        System.out.print("Nhập số lượng đầu sách mà bạn đọc muốn mượn: ");
        int number = 0;
        while (true) {
            number = new Scanner(System.in).nextInt();
            if (number < 6 && number > 0)
                break;
            System.out.print("Mỗi bạn đọc chỉ được mượn tối đa 5 đầu sách, xin mời nhập lại: ");
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Xin mời nhập thông tin của đầu sách thứ " + (i + 1));
            creatAndSaveOneOrderDetail(ORDER_BOOK_DETAILS);
        }
        //Tạo 1 oder
        return new OrderBook(reader, ORDER_BOOK_DETAILS);
    }

    public static void saveOrderToLibrary(OrderBook orderBook) {
        for (int j = 0; j < ORDERS.length; j++) {
            if (ORDERS[j] == null) {
                ORDERS[j] = orderBook;
                break;
            }
        }
    }

    // Tạo 1 order detail và lưu vào mảng entity.OrderBookDetail
    public static void creatAndSaveOneOrderDetail(OrderBookDetail[] ORDER_BOOK_DETAILS) {
        //Tạo 1 book trong order detail
        Book book = creatBookOfOrderDetail();
        //Tạo quantity book trong order detail
        System.out.print("Xin mời nhập số quyển sách muốn mượn: ");
        int bookQuantity = 0;
        while (true) {
            bookQuantity = new Scanner(System.in).nextInt();
            if (bookQuantity < 4 && bookQuantity > 0)
                break;
            System.out.print("Mỗi đầu sách chỉ được mượn tối đa 3 quyển, xin mời nhập lại: ");
        }
        // Tạo 1 order detail từ book và quantity
        OrderBookDetail orderBookDetail = new OrderBookDetail(book, bookQuantity);
        for (int k = 0; k < ORDER_BOOK_DETAILS.length; k++) {
            if (ORDER_BOOK_DETAILS[k] == null) {
                ORDER_BOOK_DETAILS[k] = orderBookDetail;
                break;
            }
        }
    }


    //5.2 In ra danh sách quản lý mượn sách
    public static void showLibrary() {
        System.out.println("--------------------------------------");
        System.out.println("Danh sách mượn sách của hệ thống là:");
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] != null) {
                System.out.println("Bạn đọc " + ORDERS[i].getReader().getName() + " mượn các đầu sách: ");
                for (int j = 0; j < ORDERS[i].getOrderBookDetails().length; j++) {
                    if (ORDERS[i].getOrderBookDetails()[j] != null)
                        System.out.println(ORDERS[i].getOrderBookDetails()[j]);
                }
            }
        }
    }

    //6
    public static void sortLibraryFollowReaderName() {
        for (int i = 0; i < ORDERS.length; i++) {
            for (int j = i+1; j < ORDERS.length; j++) {
                if (ORDERS[i] != null && ORDERS[j] != null && ORDERS[i].getReader().getName().compareTo(ORDERS[j].getReader().getName()) > 0) {
                    OrderBook temp;
                    temp = ORDERS[i];
                    ORDERS[i] = ORDERS[j];
                    ORDERS[j] = temp;
                }
            }
        }
    }

    //7
    public static void sortLibraryFollowBookQuantity() {
        for (int i = 0; i < ORDERS.length; i++) {
            for (int j = i+1; j < ORDERS.length; j++) {
                if (ORDERS[i] != null && ORDERS[j] != null && ORDERS[i].getBookQuantity() > ORDERS[j].getBookQuantity()) {
                    OrderBook temp;
                    temp = ORDERS[i];
                    ORDERS[i] = ORDERS[j];
                    ORDERS[j] = temp;
                }
            }
        }
    }

    //8
    public static void searchReaderName() {
        System.out.print("Xin mời nhập tên bạn đọc muốn tìm kiếm trong thư viện Quản lý mượn sách: ");
        String name = new Scanner(System.in).nextLine();
        int count = 0;
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] != null & ORDERS[i].getReader().getName().compareTo(name)==0) {
                System.out.println("Kết quả là");
                System.out.println("Bạn đọc " + ORDERS[i].getReader().getName() + " mượn các đầu sách: ");
                for (int j = 0; j < ORDERS[i].getOrderBookDetails().length; j++) {
                    if (ORDERS[i].getOrderBookDetails()[j] != null)
                        System.out.println(ORDERS[i].getOrderBookDetails()[j]);
                }
                count = 1;
                break;
            }
        }
        if (count == 0)
            System.out.println("Tên vừa nhập không tồn tại trong danh sách thư viện Quản lý mượn sách");

    }
}
