public class BTStr6 {
    public static void main(String[] args) {
        String str = new String("string");
        if (str.length() >= 3) {
            if (str.endsWith("ing")) {
                str += "ly";
            } else
                str += "ing";
        }
        System.out.println(str);
    }
}