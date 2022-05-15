package entity;

import constan.Specialization;

import java.util.Scanner;

public class Book implements inputInfor {

    public static int AUTO_ID =10000;

    private int id;
    private String name;
    private String author;
    private Specialization specialization;
    private int publishedYear;

    public Book() {
        this.id = AUTO_ID++;
    }

    public Book(String name, String author, Specialization specialization, int publishedYear) {
        this.name = name;
        this.author = author;
        this.specialization = specialization;
        this.publishedYear = publishedYear;
    }

    public Book(String name, String author, Specialization specialization) {
        this.name = name;
        this.author = author;
        this.specialization = specialization;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Sách mã " + id +
                ": Tên '" + name + '\'' +
                " của tác giả '" + author + '\'' +
                " thuộc thể loại " + specialization +
                ", xuất bản năm " + publishedYear ;
    }

      public void inputInfor(){
        System.out.print("Nhập tên sách: ");
        this. setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập tên tác giả: ");
        this. setAuthor(new Scanner(System.in).nextLine());
        System.out.println("--- Chuyên ngành đầu sách --- ");
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Văn học - Nghệ thuật");
        System.out.println("3. Điện tử Viễn thông");
        System.out.println("4. Công nghệ thông tin");
        System.out.print("Xin mời nhập Chuyên ngành của đầu sách: ");
        int number = 0;
        while (true) {
            number = new Scanner(System.in).nextInt();
            if (number > 0 && number < 5)
                break;
            System.out.print("Bạn nhập sai rồi, xin mời bạn nhập lại: ");
        }
        switch (number) {
            case 1:
                this.setSpecialization(Specialization.KHTN);
                break;
            case 2:
                this.setSpecialization(Specialization.VHNT);
                break;
            case 3:
                this.setSpecialization(Specialization.DTVT);
                break;
            case 4:
                this.setSpecialization(Specialization.CNTT);
                break;
        }
        System.out.print("Xin mời nhập năm xuất bản: ");
        this. setPublishedYear(new Scanner(System.in).nextInt());
    }
}
