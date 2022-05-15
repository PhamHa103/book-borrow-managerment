package service;

import entity.Reader;

import java.util.Scanner;

public class serviceReader {
    private static Reader[] READERS = new Reader[100];

    //1. Tạo bạn đọc mới
    public static void inputReader() {
        System.out.print("Xin mời nhập số lượng bạn đọc mới muốn nhập: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            Reader reader = new Reader();
            System.out.println("Xin mời nhập thông tin của bạn đọc thứ " + (i + 1));
            reader.inputInfor();
            saveReader(reader);
        }
    }

    private static void saveReader(Reader reader) {
        for (int i = 0; i < READERS.length; i++) {
            if (READERS[i] == null) {
                READERS[i] = reader;
                break;
            }
        }

    }

    // 2. In ra danh sách entity.Reader trong hệ thống
    public static void showReader() {
        System.out.println("--------------------------------------");
        if (isEmptyReader()) {
            System.out.println("Chưa có thông tin bạn đọc nào trong hệ thống, xin mời nhập thông tin bạn đọc!");
            return;
        }
        for (int i = 0; i < READERS.length; i++) {
            if (READERS[i] != null)
                System.out.println(READERS[i]);
        }
    }

    private static boolean isEmptyReader() {
        for (int i = 0; i < READERS.length; i++) {
            if (READERS[i] != null)
                return false;
        }
        return true;
    }

    // Tạo 1 entity.Reader trong Order
    public static Reader creatReaderOfOrder() {
        System.out.print("Xin mời nhập ID bạn đọc muốn mượn sách: ");
        int idReader = 0;
        while (true) {
            idReader = new Scanner(System.in).nextInt();
            if (hasReader(idReader))
                break;
            System.out.print("Địa chỉ ID bạn đọc không tồn tại trong hệ thống, xin mời nhập lại: ");
        }
        Reader reader = getReader(idReader);
        return reader;
    }

    private static Reader getReader(int idReader) {
        Reader reader = new Reader();
        for (int i = 0; i < READERS.length; i++) {
            if (READERS[i] != null && READERS[i].getId() == idReader)
                reader = READERS[i];
        }
        return reader;
    }

    public static boolean hasReader(int idReader) {
        for (int i = 0; i < READERS.length; i++) {
            if (READERS[i] != null && READERS[i].getId() == idReader)
                return true;
        }
        return false;
    }

}
