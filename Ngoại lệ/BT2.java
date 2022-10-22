package Exception;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ngay thang nam");
        int day, moth, year;
        day = getDay();
        moth = getMoth();
        year = getYear();
        LocalDate birthday = LocalDate.of(year, moth, day);
//        System.out.printf("\n %tD", birthday);
        System.out.printf("%tm/%td/%tY \n", birthday, birthday, birthday);
        LocalDate today = LocalDate.of(2000, 12, 3);
        checkAge(birthday, today);
    }

    public static int getDay() {
        Scanner sc = new Scanner(System.in);
        int day = 0;
        boolean test = true;
        while (test) {
            try {
                System.out.println("Nhap ngay: ");
                day = Integer.parseInt(sc.nextLine());
                if (day < 0 || day > 31) {
                    throw new IllegalArgumentException("Ngay khong hop le");
                }
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Ngay nhap vao khong phai la so.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return day;
    }

    public static int getMoth() {
        Scanner sc = new Scanner(System.in);
        int moth = 0;
        boolean test = true;
        while (test) {
            try {
                System.out.println("Nhap thang: ");
                moth = Integer.parseInt(sc.nextLine());
                if (moth < 0 || moth > 12) {
                    throw new IllegalArgumentException("Thang khog hop le");
                }
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Thang nhap vao khong phai la so.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moth;
    }

    public static int getYear() {
        Scanner sc = new Scanner(System.in);
        int year = 0;
        boolean test = true;
        while (test) {
            try {
                System.out.println("Nhap nam: ");
                year = Integer.parseInt(sc.nextLine());
                if (year < 1900 || year > 2022) {
                    throw new IllegalArgumentException("Nam khog hop le");
                }
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Nam nhap vao khong phai la so.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return year;
    }

    public static void checkAge(LocalDate birthday, LocalDate today) throws AgeException {
//        LocalDate today = LocalDate.of(2000, 12, 12);
        try {
            Period age = Period.between(birthday, today);
            if (age.getYears() < 0 || age.getDays() < 0 || age.getMonths() < 0) {
                throw new AgeException("Loi thoi gian");
            } else {
                System.out.println("You are " + age.getYears() + " years, " + age.getMonths() +
                        " months, and " + age.getDays() +
                        " days old.");
            }
        } catch (AgeException e) {
            System.out.printf(e.getMessage());
        }
    }
}
