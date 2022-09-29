public class BTStr20 {
    public static void main(String[] args) {
        String str = "1223";
        reverse(str);
    }

    public static String reverse(String str) {
        if (str.length() % 4 == 0) {
            char[] ch = str.toCharArray();
            char[] ch1 = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ch1[i] = ch[ch.length - 1 - i];
            }
            String str1 = new String(ch1);
            return str1;
        } else
            return "Chuoi co chieu dai khong phai boi cua 4";

    }

}
