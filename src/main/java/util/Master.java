package util;

public class Master {
    String name;
    int KOD[];
    int emp, empMAX;

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
}
