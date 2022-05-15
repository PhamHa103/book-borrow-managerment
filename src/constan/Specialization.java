package constan;

public enum Specialization {
    KHTN("Khoa học tự nhiên"),
    VHNT("Văn học _ Nghệ thuật"),
    DTVT("Điện tử viễn thông"),
    CNTT("Công nghệ thông tin");
    public String value;

    Specialization(String value) {
        this.value = value;
    }
}
