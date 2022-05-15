package constan;

public enum Type_Reader{
    SINH_VIEN("Sinh viên"),
    CAO_HOC("Cao học"),
    GIAO_VIEN("Giáo viên");
    public String value;

    Type_Reader(String value) {
        this.value = value;
    }
}
