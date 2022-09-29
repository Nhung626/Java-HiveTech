import javax.swing.text.rtf.RTFEditorKit;

public class BtStr15 {
    public static void main(String[] args) {
        addTag1("i", "aaaa");
    }
    // public static String addTag(String... value, String word){
    //     String str = "";
    //     for(String s:value){
    //         str = addTag1(s, word);
    //     }
    //     return str;
    // }
    public static String  addTag1(String tag, String word){
        return String.format("<%s>%s<%s>", tag, word, tag);
    }

}
