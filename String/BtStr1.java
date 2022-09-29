import java.util.ArrayList;

public class BtStr1 {
    public static void main(String[] args) {
        // 1
        String str1 = new String("aaaacbb");
        int dem = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == 'c') {
                dem += 1;
            }
        }
        System.out.println("Bai 1: so ki tu 'c' trong chuoi: " + dem);
        // 1.1
        String str2 = new String("Hoang@123%");
        String str3 = new String(" Nhung@123$");
        System.out.println(str2 + str3);
        // 1.2
        System.out.println(str2.toUpperCase());
        // 1.3
        dem = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (Character.isUpperCase(str2.charAt(i))) {
                dem += 1;
            }
        }
        System.out.println("So ki tu in hoa: " + dem);
        // 1.4
        dem = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (Character.isDigit(str2.charAt(i))) {
                dem += 1;
            }
        }
        System.out.println("So ki tu la so: " + dem);
        // 1.5
        System.out.print("In cac ki tu o vi tri le: ");
        for (int i = 1; i < str3.length(); i += 2) {
            System.out.print(str3.charAt(i) + " ");

        }
        // 1.6
        System.out.print("/n In cac ki tu dac biet: ");
        for (int i = 1; i < str3.length(); i += 2) {
            if (!Character.isLetterOrDigit(str3.charAt(i))) {
                System.out.print(str3.charAt(i) + " ");
            }
        }
        // 1.7
        System.out.println("Chuoi khong co khoang trang o dau la:" + str3.trim());
        // 1.8
        dem = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (Character.isLowerCase(str2.charAt(i))) {
                dem += 1;
            }
        }
        System.out.println("So ki tu la chu cai thuong: " + dem);
        // 1.9
        System.out.println(str2.substring(2)); 
        // 1.92
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < str2.length(); i++) {
            if (Character.isDigit(str2.charAt(i))) {
                arr.add((int) str2.charAt(i));
            }
        }
        //1.91
        if(str2.length()>8){
            System.out.println(str2.substring(2, 8)); 
        }
        
    }
}
