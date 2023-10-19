import java.util.ArrayList;
public class Main {
    public static void task1() {
        Task1 university = new Task1("Mannheim");
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(30);
        grades.add(38);
        grades.add(33);
        grades.add(54);
        grades.add(80);
        grades.add(99);
        grades.add(93);

        System.out.println("Problem 1: " + university.notEnough(grades));
        System.out.println("Problem 2: " + university.arithmeticMean(grades));
        System.out.println("Problem 3: " + university.recalculateGrades(grades));
        System.out.println("Problem 4: " + university.maxRecalculatedGrade(grades));
    }

    public static void task2() {
        Task2 javaArray = new Task2(5);
        javaArray.populateArray();
        javaArray.printingArray();
        System.out.println("Maximum: " + javaArray.maximum());
        System.out.println("Minimum: " + javaArray.minimum());
        System.out.println("Max Sum: " + javaArray.maxSum());
        System.out.println("Min Sum: " + javaArray.minSum());

    }
    public static void task3() {
        Task3 operations = new Task3(130000000,870000000);
        operations.printNumbers();
        System.out.println();
        System.out.println("Sum: ");
        for(int i = 0;i<operations.calculateSum().length;i++)
            System.out.print(operations.calculateSum()[i] + " ");
        System.out.println();
        Task3 operations2 = new Task3(830000000,540000000);
        System.out.println("Difference: ");
        for(int i = 0;i<operations2.calculateDifference().length;i++)
            System.out.print(operations2.calculateDifference()[i] + " ");
        System.out.println();
        Task3 operations3  = new Task3(236000000,2);
        System.out.println("Multiplication: ");
        for(int i = 0;i<operations3.multiplication().length;i++)
            System.out.print(operations3.multiplication()[i] + " ");
        Task3 operations4 = new Task3(236000000,2);
        System.out.println();
        System.out.println("Division: ");
        for(int i = 0;i<operations4.division().length;i++)
            System.out.print(operations4.division()[i] + " ");
    }
    public static void task4(){
        int[] keyboard = {15,20,10,35};
        int[] usbDrives = {20,15,40,15};
        ElectronicShop shop = new ElectronicShop(keyboard,usbDrives);
        System.out.println("Cheapest keyboard: "+ shop.cheapestKeyboard());
        System.out.println("Most expensive Item: "+ shop.mostExpensiveItem());
        System.out.println("On buget USB: "+ shop.onBugetUSB(19));

        int[] keyboard2 = {40,50,60};
        int[] usbDrives2 = {30,40};
        ElectronicShop shop2 = new ElectronicShop(keyboard2,usbDrives2);
        System.out.println("On buget bill: " + shop2.onBugetItems(60));
    }
    public static void main(String[] args) {
        task4();
    }
}