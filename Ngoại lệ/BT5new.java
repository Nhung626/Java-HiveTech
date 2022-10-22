package Exception;

import java.time.LocalDate;

public class BT5new {
    public static void main(String[] args) {

        String str = "id: 1a;name: Mrz Jonh; birthDay: 21/1a/1999";
        boolean test = true;
        String[] err = new String[3];
        String[] infor = str.trim().split(";");
        String[] id = infor[0].trim().split(":");
        if (id[0].equals("id")) {
            try {
                int Id = Integer.parseInt(id[1].trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                err[0] = String.format("id: %s: Can't parse a to int", id[1]);
                test = false;
            }
        }
        String[] name = infor[1].trim().split(":");
        if (name[0].equals("name")) {
            try {
                String nameStu = name[1].trim();
                for (int i = 0; i < nameStu.length(); i++) {
                    if (!(Character.isLetter(nameStu.charAt(i)) || Character.isWhitespace(nameStu.charAt(i)))) {
                        err[1] = String.format("name: %s: Can't convert", name[1]);
                        test = false;
                        throw new StudentConvertExeption("Co chua ky tu hong phai ky tu anphabel hay khoang trang");
                    }
                }
            } catch (StudentConvertExeption e) {
                System.out.println(e.getMessage());
            }
        }
        String[] BD = infor[2].trim().split(":");
        LocalDate birthDayStu;
        int ngay = 0, thang = 0, nam = 0;
        if (BD[0].equals("birthDay")) {
            String[] brithDay = BD[1].trim().split("/");
            try {
                ngay = Integer.parseInt(brithDay[0]);
                thang = Integer.parseInt(brithDay[1]);
                nam = Integer.parseInt(brithDay[2]);
                if (ngay < 0 || ngay > 31) {
                    test = false;
                    err[2] = String.format("birthDay: %s: Can't convert", BD[1]);
                    throw new StudentConvertExeption("Ngay khong hop le");
                }
                if (thang < 0 || thang > 12) {
                    test = false;
                    err[2] = String.format("birthDay: %s: Can't convert", BD[1]);
                    throw new StudentConvertExeption("Thang khong hop le");
                }
                if (nam < 1900 || nam > 2022) {
                    test = false;
                    err[2] = String.format("birthDay: %s: Can't convert", BD[1]);
                    throw new StudentConvertExeption("Nam khong hop le");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dau vao khong phai la so.");
            } catch (StudentConvertExeption e) {
                System.out.println(e.getMessage());
            }
        }
        birthDayStu = LocalDate.of(nam, thang, ngay);

        if (test) {
            System.out.printf("Student(id - %d, name - %s, birthDay - %tm/%td/%tY)", id, name, birthDayStu, birthDayStu, birthDayStu);
        } else {
            for (int i = 0; i < err.length; i++) {
                System.out.println(err[i]);
            }
            throw new StudentConvertExeption("Loi convert");
        }
    }


}
