package Exception;

import java.util.Scanner;

public class BT4 {
    public static void main(String[] args) {
    String fullName = getFullName();
    System.out.println("Full name: "+fullName);
    }

    public static String getFullName() {
        Scanner sc = new Scanner(System.in);
        String fullName = "";
        boolean test = true;
        while (test) {
            try {
                System.out.println("Nhap ten: ");
                fullName = sc.nextLine();
                for (int i = 0; i < fullName.length(); i++) {
                    if (! (Character.isLetter(fullName.charAt(i)) || Character.isWhitespace(fullName.charAt(i)))){
                        throw new RuntimeException("Co chua ky tu hong phai ky tu anphabel hay khoang trang");
                    }
                }
                test = false;
            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
        return fullName;
    }
}
