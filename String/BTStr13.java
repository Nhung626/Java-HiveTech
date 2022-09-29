import java.util.Scanner;
public class BTStr13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("Nhap chuoi: ");
        str = sc.nextLine();
        System.out.println("Chuoi viet in hoa: "+str.toUpperCase());
        System.out.println("Chuoi viet in thuong: "+str.toLowerCase());
    }
}
