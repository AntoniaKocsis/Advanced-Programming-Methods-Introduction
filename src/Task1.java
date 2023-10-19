import java.util.ArrayList;
import java.util.Collections;

public class Task1 {
    private String name;

    public Task1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Prob 1.
    public ArrayList<Integer> notEnough(ArrayList<Integer> grades) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int grade : grades) {
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException("Not a viable grade!");
            } else {
                if (grade < 40) {
                    arrayList.add(grade);
                }
            }
        }
        return arrayList;
    }

    // Prob 2.
    public float arithmeticMean(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            if (grade >= 0 && grade <= 100) {
                sum += grade;
            }
        }
        return (float) sum / grades.size();

    }

    // Prob 3.
    public ArrayList<Integer> recalculateGrades(ArrayList<Integer> grades) {
        for (int grade : grades) {
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException("Not a viable grade!");
            }
        }
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            if (grade > 38) {
                int firstM = grade;
                while (firstM % 5 != 0) {
                    firstM++;
                }
                if (grade - firstM < 3) {
                    grades.set(i, firstM);
                }

            }
        }
        return grades;
    }

    // Prob 4.
    public int maxRecalculatedGrade(ArrayList<Integer> grades) {
        ArrayList<Integer> newGrades = new ArrayList<>();
        newGrades = recalculateGrades(grades);
        return Collections.max(newGrades);
    }
}
