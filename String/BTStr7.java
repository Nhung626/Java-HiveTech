public class BTStr7 {
    public static void main(String[] args) {
        String str = new String("ab cske dd asd aaabdg");
        String[] arr = str.split(" ");
        String maxLength = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxLength.length() < arr[i].length()) {
                maxLength = arr[i];
            }
        }
        System.out.println("Longest word: " + maxLength);
        System.out.println("Length of longest word: " + maxLength.length());
    }
}
