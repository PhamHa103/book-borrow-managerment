package entity;

import constan.Type_Reader;

import java.util.Scanner;

public class Reader implements inputInfor {

    public static int AUTO_ID = 10000;

    private int id;
    private String name;
    private String phone;
    private String address;
    public Type_Reader typeReader;

    public Reader() {
        this.id = AUTO_ID++;
    }

    public Reader(String name, String phone, String address, Type_Reader typeReader) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.typeReader = typeReader;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type_Reader getTypeReader() {
        return typeReader;
    }

    public void setTypeReader(Type_Reader typeReader) {
        this.typeReader = typeReader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Bạn đọc mã " + id +
                ": tên '" + name + '\'' +
                " có SĐT ='" + phone + '\'' +
                " ở " + address +
                ", loại bạn đọc - " + typeReader ;
    }

    public void inputInfor() {
        System.out.print("Nhập tên bạn đọc: ");
        this. setName(new Scanner(System.in).nextLine());
        System.out.print("Xin mời nhập địa chỉ của bạn đọc: ");
        this. setAddress(new Scanner(System.in).nextLine());
        System.out.print("Xin mời nhập số điện thoại của bạn đọc: ");
        this. setPhone(new Scanner(System.in).nextLine());
        System.out.println("--- Loại bạn đọc --- ");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giáo viên");
        System.out.print("Xin mời nhập loại bạn đọc: ");
        int number = 0;
        while (true) {
            number = new Scanner(System.in).nextInt();
            if (number > 0 && number < 4)
                break;
            System.out.print("Bạn nhập sai rồi, xin mời bạn nhập lại: ");
        }
        switch (number) {
            case 1:
                this.setTypeReader(Type_Reader.SINH_VIEN);
                break;
            case 2:
                this.setTypeReader(Type_Reader.CAO_HOC);
                break;
            case 3:
                this.setTypeReader(Type_Reader.GIAO_VIEN);
                break;
        }
    }
}
