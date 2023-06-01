import java.util.InputMismatchException;
import java.util.Scanner;

public class Check {
    private static int qtyPeople; //количество людей для разделения счета

    public static int getQtyPeople(){
        return qtyPeople;
    }

    public static void setQtyPeople() {
        while (true) {
            System.out.println("На сколько человек необходимо разделить счет?");
            try{
                Scanner scanner = new Scanner(System.in);
                qtyPeople = scanner.nextInt();
                if (qtyPeople == 1) {
                    System.out.println("Введено количество людей равное 1. Нет смысла делить счет\n");
                } else if (qtyPeople < 1) {
                    System.out.println("Ошибка! Введено отрицательное (или 0) количества людей!\n");
                } else {
                    break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Ошибка! Введена неккоректная запись количества людей!\n");
            }


        }

    }
}
