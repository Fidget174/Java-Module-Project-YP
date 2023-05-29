import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {
    private String name;
    private double price;
    private static String totalList;    //строка для сбора всех товаров
    private static double totalSum;     // общая стоимость товаров

    Product (){
        setName();
        setPrice();
        printName();
    }

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public static String getTotalList(){
        return totalList;
    }
    public static double getTotalSum(){
        return totalSum;
    }

    public void setName() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название товара:");
            this.name = scanner.nextLine();
            if (getName().isEmpty()) {
                System.out.println("Ошибка! Вы ввели пустую строку!\n");
            } else {
                break;
            }
        }
            if (totalList != null) {
                totalList = totalList + "\n" + this.name;
            } else {
                totalList = this.name;
            }
    }
    public void setPrice(){
        while(true) {
            System.out.println("Введите стоимость товара в формате Рубли.Копейки:");
            Scanner scanner = new Scanner (System.in);
            try {
                this.price = scanner.nextDouble();
                double modPrice = this.price * 1000 % 10; //переменная для проверки формата рубли.копейки
                if (this.price<=0){
                    System.out.println("Ошибка! Введите положительное значение");
                } else if (modPrice >0) {
                    System.out.println("Ошибка! Введенно число НЕ в формате Рубли.Копейки");
                } else {
                    totalSum = totalSum + this.price;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите корректное значение");
            }
        }
    }

    public  void printName (){ //Вывод на экран успешного добавления товара
        System.out.println(String.format("Товар %s стоимостью %.2f успешно добавлен!\n", this.name, this.price));
    }

    public static void printTotalList(){ //вывод на экран списка товаров
        System.out.println (String.format("\nДобавленные товары:\n%s\n", totalList));
    }

    public static void printTotalSum(int qtyPeople){ //вывод на экран оплаты для каждого человека
        double totalCheckOne = totalSum / (double) qtyPeople; //счет на 1 человека
        int flagRub = (int) totalCheckOne % 10; // флаг проверки на окончание
        String string = "Сумма оплаты: " + String.format("%.2f", totalCheckOne)+ " рубл";
        switch (flagRub) { //я писал обычный switch, но Android Studio предложил заменить на enhanced switch (красивое)
            case 1 -> string = string + "ь";
            case 2, 3, 4 -> string = string + "я";
            case 0, 5, 6, 7, 8, 9 -> string = string + "ей";
            default -> {
            }
        }
        System.out.println(string);
    }

    public static boolean checkExit(){      //проверка на "Завершить"
            System.out.println("Ввести еще один товар или завершить?");
        Scanner scanner = new Scanner (System.in);
        String stringCheck = scanner.nextLine();
        boolean flagCheck = stringCheck.equalsIgnoreCase("завершить");
        if (flagCheck){
            scanner.close();
            return true;
        } else {
            return false;
        }
    }


}
