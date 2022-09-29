public class BTStr21 {
    public static void main(String[] args) {
        String str = "asAKOiial";
        String str1 = "asdfghjk";
        System.out.println(convert(str));
        System.out.println(convert(str1));
    }

    public static String convert(String str) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                count++;
            }
        }
        if (count >= 2) {
            return str.toUpperCase();
        }
        return str;
    }
}
