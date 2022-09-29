public class BTStr5 {
    public static void main(String[] args) {
        
        String str1 = new String("abc");
        String str2 = new String("xyz");
        String str3 = str1.replace(str1.substring(0, 2), str2.substring(0, 2));
        String str4 = str2.replace(str2.substring(0, 2), str1.substring(0, 2));
        String str = str3 + " " + str4;
        System.out.println(str);
    }
}
