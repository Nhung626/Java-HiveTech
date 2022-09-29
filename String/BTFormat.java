import java.time.LocalDate;
import java.time.LocalDateTime;

public class BTFormat {
    public static void main(String[] args) {
        System.out.printf("%010d", 155);

        LocalDate date = LocalDate.now();
        System.out.printf("\n %tD", date);
        System.out.printf("\n %tm/%td/%tY", date, date, date);
        LocalDateTime dateTime = LocalDateTime.now();
        // System.out.println(dateTime.toString());
        System.out.printf("\n %td/%tm/%tY %tT", date,date,date,dateTime);

        System.out.printf("\n %.2f", 15525.5);
        System.out.printf("\n %,d", 1000000825);
        System.out.printf("\n %.3f", 5.8548);
        System.out.printf("\n %td.%tm.%ty", date, date, date);



    }
}
