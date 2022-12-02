import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PeopleAmount.peopleCounter();
    }

    public static class PeopleAmount {
        public static int amount;

        public static void peopleCounter() {

            while (true) {
                System.out.println("How many people?");
                Scanner scanner = new Scanner(System.in);

                if (scanner.hasNextInt()) {
                    amount = scanner.nextInt();
                } else {
                    System.out.println("You should have entered amount");
                    continue;
                }

                if (amount <= 1) {
                    System.out.println("Amount of people should be at least 2");
                } else {

                    Calculate.calculate();
                }
            }
        }
    }

    public static class Calculate {
        static double price;
        public static double sum = 0;

        public static String allProducts = "\n";


        public static void calculate() {
            while (true) {
                System.out.println("Enter the name of product");
                Scanner scanner = new Scanner(System.in);
                String product = scanner.next();
                if (product.equalsIgnoreCase("завершить")) {
                    Result.result();


                }

                System.out.println("Enter product price in the format 'rubles,kopecks'(xx,xx)");
                if (scanner.hasNextDouble()) {

                    price = scanner.nextDouble();

                } else {
                    System.out.println("You should have entered price");
                    continue;
                }
                if (price >= 0) {
                    sum = sum + price;
                    allProducts += product + "\n";
                    System.out.println("Product successfully added");
                    System.out.println("Products: " + allProducts + "Final price= " + sum);
                    System.out.println("Type \"завершить\" if you want to end calculation");

                } else {
                    System.out.println("Price should be more than 0");
                    continue;
                }

            }
        }


    }

    public static class Result {
       static double everyoneShouldPay = Calculate.sum / PeopleAmount.amount;
        public static void result() {

            System.out.println("Added products:" + Calculate.allProducts);
            System.out.println("Price: " + Calculate.sum);
            Result.money();
        }

        public static void money() {
            double everyoneShouldPay = Calculate.sum / PeopleAmount.amount;
            int value =(int) everyoneShouldPay;
            int x = value % 10;
            String strDouble= "Everyone should pay  %.2f ";

            if (value % 100 >= 11 && value % 100 <= 14) {
                System.out.println(String.format(strDouble,everyoneShouldPay) + " рублей");
            } else {
                switch (x) {
                    case 1:
                        System.out.println(String.format(strDouble,everyoneShouldPay)+ " рубль");
                        break;
                    case 2:
                    case 3:
                    case 4:
                        System.out.println(String.format(strDouble,everyoneShouldPay)+ " рубля");
                        break;
                    default:
                        System.out.println(String.format(strDouble,everyoneShouldPay)+ " рублей");


                }
            }
            System.exit(0);
        }
    }
}


//e




