import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Check.setQtyPeople(); //Ввод количества человек
        Product product = new Product();
        while(true) {
            if (!Product.checkExit()) {//проверка на Выход
                product.setName();
                product.setPrice();
                product.printName();
            } else {
                break;
            }
        }
        Product.printTotalList();
        Product.printTotalSum(Check.getQtyPeople());
    }
}
