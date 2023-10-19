public class Task3 {
    public int[] number1;
    public int[] number2;

    public Task3(int nr1, int nr2) {

        int length1 = 0;
        int length2 = 0;
        int copyNumber1 = nr1;
        int copyNumber2 = nr2;

        while (copyNumber1 != 0) {
            length1++;
            copyNumber1 = copyNumber1 / 10;
        }
        while (copyNumber2 != 0) {
            length2++;
            copyNumber2 = copyNumber2 / 10;
        }
        if(nr2 == 0)
        {
            length2 = 1;
        }
        number1 = new int[length1];
        number2 = new int[length2];
        copyNumber1 = nr1;
        copyNumber2 = nr2;

        length1--;
        length2--;

        while (copyNumber1 != 0) {
            number1[length1] = copyNumber1 % 10;
            copyNumber1 = copyNumber1 / 10;
            length1--;
        }

        while (copyNumber2 != 0) {
            number2[length2] = copyNumber2 % 10;
            copyNumber2 = copyNumber2 / 10;
            length2--;
        }
        if(nr2 == 0)
            number2[0] = 0;


    }

    public void printNumbers() {
        System.out.println("Number 1:");
        for (int j : number1) System.out.print(j + " ");
        System.out.println();
        System.out.println("Number 2:");
        for (int j : number2) System.out.print(j + " ");
    }

    public int[] calculateSum() {
        if (number1.length != number2.length)
            throw new IllegalArgumentException("Numbers must have the same length");
        int[] result = new int[number1.length + 1];
        int carryFlag = 0;

        for (int i = number1.length - 1; i >= 0; i--) {
            int digitNumber1 = number1[i];
            int digitNumber2 = number2[i];

            int sum = digitNumber1 + digitNumber2 + carryFlag;
            result[i + 1] = sum % 10;
            carryFlag = sum / 10;
        }

        if (carryFlag > 0) {
            result[0] = carryFlag;
        } else {
            int[] finalResult = new int[number1.length];
            System.arraycopy(result, 1, finalResult, 0, number1.length);
            return finalResult;

        }
        return result;

    }

    public int[] calculateDifference() {
        if (number1.length != number2.length)
            throw new IllegalArgumentException("Numbers must have the same length");

        int[] result = new int[number1.length];
        int carryFlag = 0;

        for (int i = number1.length - 1; i >= 0; i--) {
            int difference = number1[i] - number2[i] - carryFlag;

            if (difference < 0) {
                difference += 10;
                carryFlag = 1;
            } else {
                carryFlag = 0;
            }

            result[i] = difference;
        }

        int index = 0;
        while (index < result.length && result[index] == 0) {
            index++;
        }

        if (index == result.length) {
            return new int[]{0};
        }

        int[] finalResult = new int[number1.length - index];
        System.arraycopy(result, index, finalResult, 0, number1.length - index);
        return finalResult;

    }

    public int[] multiplication() {
        if (number2.length != 1)
            throw new IllegalArgumentException("Second number must contain a single digit");
        int multiplier = number2[0];
        if (multiplier == 0 || number1[0] == 0)
            return new int[]{0};
        int[] result = new int[number1.length + 1];
        int carryFlag = 0;

        for (int i = number1.length - 1; i >= 0; i--) {
            int product = (number1[i] * multiplier) + carryFlag;
            result[i + 1] = product % 10;
            carryFlag = product / 10;
        }

        result[0] = carryFlag;


        int startIndex = 0;
        while (startIndex < result.length - 1 && result[startIndex] == 0) {
            startIndex++;
        }

        if (startIndex == result.length - 1) {
            return new int[]{0};
        }

        int[] finalResult = new int[result.length - startIndex];
        System.arraycopy(result, startIndex, finalResult, 0, finalResult.length);
        return finalResult;

    }
    public int[] division() {
        if(number2[0] == 0)
            throw new ArithmeticException("Division by 0 not possible");
        if (number2.length != 1 || number2[0] == 0)
            throw new IllegalArgumentException("Second number must contain single digit");

        int divisor = number2[0];
        int[] result = new int[number1.length];
        int remainder = 0;

        for (int i = 0; i < number1.length; i++) {
            int currentDigit = number1[i] + remainder * 10;
            result[i] = currentDigit / divisor;
            remainder = currentDigit % divisor;
        }

        int startIndex = 0;
        while (startIndex < result.length && result[startIndex] == 0) {
            startIndex++;
        }

        if (startIndex == result.length) {
            return new int[]{0}; // The result is zero
        }

        int[] finalResult = new int[result.length - startIndex];
        System.arraycopy(result, startIndex, finalResult, 0, finalResult.length);

        return finalResult;
    }

}
