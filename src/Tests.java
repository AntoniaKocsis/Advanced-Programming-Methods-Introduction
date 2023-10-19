import java.util.ArrayList;

public class Tests {
    public static void testTask1() {
        Task1 university = new Task1("Mannheim");
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(30);
        grades.add(38);
        grades.add(33);
        grades.add(54);
        grades.add(80);
        grades.add(99);
        grades.add(93);
        System.out.println("Testing task 1: ");
        System.out.println("1. Non passing grades Test");
        try {
            System.out.println("    - Expected case Test");
            assert university.notEnough(grades).get(0) == 30;
            assert university.notEnough(grades).get(1) == 38;
            assert university.notEnough(grades).get(2) == 33;
            grades.add(-5);
            assert university.notEnough(grades).get(3) == -5;
        } catch (IllegalArgumentException e) {
            System.out.println("    - Unwanted case Test(Number not in range)");
            grades.removeLast();
        }

        System.out.println("2. Arithmetic mean Test");
        assert university.arithmeticMean(grades) == 61;
        System.out.println("3. Recalculating grades Test");
        ArrayList<Integer> result = new ArrayList<>();
        result = university.recalculateGrades(grades);
        assert result.get(3) == 55;
        assert result.get(5) == 100;
        assert result.get(6) == 95;
        System.out.println("4. Max of recalculated grades Test");
        assert university.maxRecalculatedGrade(grades) == 100;


    }

    public static void testTask2() {
        System.out.println();
        System.out.println("Testing task 2: ");
        Task2 javaArray = new Task2();
        System.out.println("1. Maximum Test");
        assert javaArray.maximum() == 17;
        System.out.println("2. Minimum Test");
        assert javaArray.minimum() == 3;
        System.out.println("3. Max sum Test");
        assert javaArray.maxSum() == 39;
        System.out.println("4. Min sum Test");
        assert javaArray.minSum() == 25;
        try {
            javaArray.addValue(-5);
            assert javaArray.minimum() == -5;

        } catch (Exception e) {
            System.out.println("- Unwanted case Test (Negative numbers found)");
        }

    }

    public static void testTask3() {
        System.out.println();
        System.out.println("Testing task 3: ");
        System.out.println("1. Sum Test");
        Task3 operations = new Task3(130000000, 870000000);
        int sum = operations.calculateSum()[0];
        for (int i = 1; i < operations.calculateSum().length; i++)
            sum = (sum * 10) + operations.calculateSum()[i];


        System.out.println("2. Difference Test ");
        Task3 operations2 = new Task3(830000000, 540000000);
        int difference = operations2.calculateDifference()[0];
        for (int i = 1; i < operations2.calculateDifference().length; i++)
            difference = (difference * 10) + operations2.calculateDifference()[i];
        assert difference == 830000000 - 540000000;


        System.out.println("3. Multiplication Test");
        Task3 operations3 = new Task3(236000000, 2);
        int multiplication = operations3.multiplication()[0];
        for (int i = 1; i < operations3.multiplication().length; i++)
            multiplication = (multiplication * 10) + operations3.multiplication()[i];
        assert multiplication == 236000000 * 2;

        System.out.println("4. Division Test");
        Task3 operations4 = new Task3(236000000, 2);
        int division = operations4.division()[0];
        for (int i = 1; i < operations4.division().length; i++)
            division = (division * 10) + operations4.division()[i];
        assert division == 236000000 / 2;
        try {
            Task3 operations5 = new Task3(236000000, 0);
            operations5.division();
        } catch (Exception e) {
            System.out.println("5. 0 Division Test: " + e.getMessage());
        }


    }

    public static void testTask4() {
        System.out.println();
        System.out.println("Testing task 4: ");
        int[] keyboard = {15, 20, 10, 35};
        int[] usbDrives = {20, 15, 40, 15};
        ElectronicShop shop = new ElectronicShop(keyboard, usbDrives);
        System.out.println("1. Cheapest keyboard Test");
        assert shop.cheapestKeyboard() == 10;
        System.out.println("2. Most expensive item Test");
        assert shop.mostExpensiveItem() == 40;
        System.out.println("3. On buget USB Drive Test");
        assert shop.onBugetUSB(19) == 15;


        System.out.println("4. On buget items Test");
        int[] keyboard2 = {40, 50, 60};
        int[] usbDrives2 = {8, 12};
        ElectronicShop shop2 = new ElectronicShop(keyboard2, usbDrives2);
        assert shop2.onBugetItems(60) == 58;

        System.out.println("5. Unwanted case Test");
        int[] keyboard3 = {40,50,60};
        int[] usbDrives3 = {30,40};
        ElectronicShop shop3 = new ElectronicShop(keyboard3,usbDrives3);
        assert shop3.onBugetItems(60) == -1;
    }

    public static void main(String[] args) {
        testTask1();
        testTask2();
        testTask3();
        testTask4();
    }
}
