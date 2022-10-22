package Exception;

import java.time.LocalDate;

//BT2
public class AgeException extends RuntimeException{
    LocalDate time;
    public  AgeException(String message){
        super(message);
    }
}
