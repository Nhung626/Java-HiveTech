public class BTStr2 {
    public static void main(String[] args) {

        String str = "google.com";
        System.out.println(str);

        int counter[] = new int[256];
        int len = str.length();
        for (int i = 0; i < len; i++)
            counter[str.charAt(i)]++;
        char array[] = new char[str.length()];
        int flag;
        for (int i = 0; i < len; i++) {
            array[i] = str.charAt(i);
            flag = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == array[j])
                    flag++;
            }
            if (flag == 1)
                System.out.println(String.format("'%c': %d", str.charAt(i), counter[str.charAt(i)]));
        }
    }

}
