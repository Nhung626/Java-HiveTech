package Exception;

import java.time.LocalDate;

public class BT5 {
    public static void main(String[] args) {
        convertStudent("id: 1a;name: Mrz Jonh; birthDay: 21/01/1999");
    }

    public static void convertStudent(String str) {
        String[] infor = str.trim().split(";");
        String[] id = infor[0].trim().split(":");
        int idStu = getId(id);
        String[] name = infor[1].trim().split(":");
        String nameStu = getName(name);
        String[] birthday = infor[2].trim().split(":");
        LocalDate brithday = getDay(birthday);
        System.out.printf("Student(id - %d, name - %s, birthDay - %tm/%td/%tY)", idStu, nameStu, brithday, brithday, brithday);
    }

    public static int getId(String[] id) {
        int Id = 0;
        try {
            if (id[0].equals("id")) {
                Id = Integer.parseInt(id[1].trim());
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.printf("[id: %s: Can't parse a to int]", id[1]);
        }
        return Id;
    }

    public static String getName(String[] name) {
        String nameStu = "";
        if (name[0].equals("name")) {
            nameStu = name[1].trim();
            for (int i = 0; i < nameStu.length(); i++) {
                if (!(Character.isLetter(nameStu.charAt(i)) || Character.isWhitespace(nameStu.charAt(i)))) {
                    System.out.printf("[name: %s: co ki tu khac anpha]");
                    throw new StudentConvertExeption("Co chua ky tu hong phai ky tu anphabel hay khoang trang");
                }
            }
        }
        return nameStu;
    }

    public static LocalDate getDay(String[] day) {
        LocalDate dd = LocalDate.now();
        if (day[0].equals("birthDay")) {
            String[] brithDay = day[1].trim().split("/");
            int ngay = Integer.parseInt(brithDay[0]);
            int thang = Integer.parseInt(brithDay[1]);
            int nam = Integer.parseInt(brithDay[2]);
            try {
                if (ngay < 0 || ngay > 31) {
//                    test = false;
                    throw new StudentConvertExeption("Ngay khong hop le");
                }
                if (thang < 0 || thang > 12) {
//                    test = false;
                    throw new StudentConvertExeption("Thang khong hop le");
                }
                if (nam < 1900 || nam > 2022) {
//                    test = false;
                    throw new StudentConvertExeption("Nam khong hop le");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dau vao khong phai la so.");
            } catch (StudentConvertExeption e) {
                System.out.println(e.getMessage());
            }
            return LocalDate.of(nam, thang, ngay);
        }
        return dd;
    }
}
