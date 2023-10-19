import java.util.Scanner;

public class Task2 {
    public int size;
    public int[] array;

    public Task2(int size) {
        this.size = size;
        array = new int[size];
    }

    public Task2() {
        this.size = 5;
        array = new int[size];
        array[0] = 4;
        array[1] = 8;
        array[2] = 3;
        array[3] = 10;
        array[4] = 17;
    }

    public void populateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter " + size + " positive numbers: ");
        for (int i = 0; i < size; i++) {
            int number = scanner.nextInt();
            if (number < 0)
                throw new IllegalArgumentException("Number must be a positive number");
            else {
                array[i] = number;
            }
        }
    }

    public void printingArray() {
        for (int i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public void addValue(int value) {
        array[size] = value;
        size++;

    }

    public void checkValues() {
        for(int i = 0;i<size;i++)
            if(array[i]<0)
                throw new IllegalArgumentException("Number must be a positive number");
    }

    public int maximum() {
        checkValues();
        int maxi = array[0];
        for (int i = 0; i < size; i++)
            if (maxi < array[i]) {
                maxi = array[i];
            }
        return maxi;

    }

    public int minimum() {
        checkValues();
        int min = array[0];
        for (int i = 0; i < size; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public int maxSum() {
        checkValues();
        int maxiSum = 0;
        for (int i = 0; i < size; i++) {
            maxiSum += array[i];
        }
        maxiSum -= minimum();

        return maxiSum;
    }

    public int minSum() {
        checkValues();
        int minSum = 0;
        for (int i = 0; i < size; i++) {
            minSum += array[i];
        }
        minSum -= maximum();

        return minSum;
    }

}
