import java.util.ArrayList;

public class ElectronicShop {
    public int[] keyboards;
    int keyBoardSize;
    public int[] usbDrives;
    int usbDrivesSize;

    public ElectronicShop(int[] keyboards, int[] usbDrives) {
        this.keyboards = keyboards;
        this.usbDrives = usbDrives;
        keyBoardSize = keyboards.length;
        usbDrivesSize = usbDrives.length;
    }

    public void addKeyboard(int keyBoard) {
        keyboards[keyBoardSize] = keyBoard;
        keyBoardSize++;

    }

    public void addUSBDrive(int usbDrive) {
        usbDrives[usbDrivesSize] = usbDrive;
        usbDrivesSize++;
    }

    public int cheapestKeyboard() {
        int min = keyboards[0];
        for (int i = 0; i < keyBoardSize; i++)
            if (min > keyboards[i])
                min = keyboards[i];
        return min;
    }

    public int cheapestUSBDrive() {
        int min = usbDrives[0];
        for (int i = 0; i < usbDrivesSize; i++)
            if (min > usbDrives[i])
                min = usbDrives[i];
        return min;
    }

    public int cheapestUSBDrivePosition() {
        int min = cheapestUSBDrive();
        for (int i = 0; i < usbDrivesSize; i++)
            if (min == usbDrives[i])
                return i;
        return -1;
    }

    public int mostExpensiveKeyboard() {
        int max = keyboards[0];
        for (int i = 0; i < keyBoardSize; i++)
            if (max < keyboards[i])
                max = keyboards[i];
        return max;
    }

    public int mostExpensiveUSBDrive() {
        int max = usbDrives[0];
        for (int i = 0; i < usbDrivesSize; i++)
            if (max < usbDrives[i])
                max = usbDrives[i];
        return max;
    }


    public int mostExpensiveItem() {
        int maxUSB = mostExpensiveUSBDrive();
        int maxKeyboard = mostExpensiveKeyboard();
        return Math.max(maxKeyboard, maxUSB);
    }

    public int onBugetUSB(int buget) {
        int minDifference = buget - this.cheapestUSBDrive();
        int usbDrive = usbDrives[this.cheapestUSBDrivePosition()];
        for (int i = 0; i < usbDrivesSize; i++) {
            int diff = buget - usbDrives[i];
            if (diff < minDifference && diff > 0) {
                minDifference = diff;
                usbDrive = usbDrives[i];
            }
        }
        return usbDrive;

    }

    public int onBugetItems(int buget) {
        if (cheapestKeyboard() > buget || cheapestUSBDrive() > buget)
            return -1;
        if (cheapestUSBDrive() + cheapestKeyboard() > buget)
            return -1;
        int bill = 0;
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < keyBoardSize; i++)
            for (int j = 0; j < usbDrivesSize; j++) {
                sums.add(keyboards[i] + usbDrives[j]);
            }
        int minDifference = buget - (cheapestKeyboard() + cheapestUSBDrive());
        for (int sum : sums) {
            int diff = buget - sum;
            if (diff < minDifference && diff > 0) {
                minDifference = diff;
                bill = sum;
            }
        }
        return bill;
    }
}
