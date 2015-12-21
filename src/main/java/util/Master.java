package util;

public class Master implements Comparable<Master>{
    String name;
    int KOD[];
    int emp, empMAX;

    public Master(String n, int kod[], int emax) {
        name = n;
        KOD = kod;
        emp = 0;
        empMAX = emax;
    }

    public Master(String n, int kod[], int e, int emax) {
        name = n;
        KOD = kod;
        emp = e;
        empMAX = emax;
    }

    /*
    public boolean isEmployeble() {

        if (emp < empMAX) {
            return true;
        }
        return false;
    }
    */

    public void EmployUp() {
        emp++;
    }

    public void EmployDown() {
        emp--;
    }

    public int isCan(int kod) {
        int i;
        for (i = 0; i < KOD.length; i++) {
            if (KOD[i] == kod) {
                return (empMAX - emp);
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public int[] getKOD() {
        return KOD;
    }

    public int getEmp() {
        return emp;
    }

    public int getEmpMAX() {
        return empMAX;
    }

    public int compareTo(Master o) {
        return name.compareTo(o.getName());
    }

    public boolean equals(Master o) {
        if (name.equals(o.getName())) {
            return true;
        }
        return false;
    }
}
