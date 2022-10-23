package Exception;

public class BT3 {
    public static void main(String[] args){
    String[] arr = {"3","43","a"};
    SumArr(arr);
    }
    public  static  void SumArr(String arr[]) throws SumCalcException{
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            try {
                sum+= Integer.parseInt(arr[i]);

            }catch (NumberFormatException e){
                System.out.printf("%s khong phai la so\n", arr[i]);
            }
            catch (SumCalcException e){
                System.out.println("Loi");
                System.out.println(e.getMessage());
            }
        }
//        System.out.println(sum);
    }
}
