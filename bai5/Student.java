public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return this.program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getfee() {
        return this.fee;
    }

    public void setfee(double fee) {
        this.fee = fee;
    }

    public String toString() {
        return String.format("Student[%s,program=%s,year=%d,fee=%f]", super.toString(), this.program, this.year,
                this.fee);
    }

    public static void main(String[] args) {
        Student sv = new Student("Nhung", "EFGH", "y1", 2002, 4321);
        System.out.println(sv.toString());
    }
}
