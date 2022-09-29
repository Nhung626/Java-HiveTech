public class BTStr10 {
    public static void main(String[] args) {
        String str = new String("alohahoho");
        String str1 = str.charAt(str.length()-1)+str.substring(1, str.length()-1)+str.charAt(0);
        System.out.println(str1);
    }

}
