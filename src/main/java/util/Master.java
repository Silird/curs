package util;

public class Master {
    int KOD[];
    int emp, empMAX;

    public Master(int kod[], int e, int emax) {
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
