package util;

/**
 * Класс мастера
 * Содержит:
 * Имя мастера
 * Специализации
 * Текущую загрузку
 * Максимальную загрузку
 */
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

    /**
     * Прибавление загрузки
     */
    public void EmployUp() {
        emp++;
    }

    /**
     * Уменьшение загрузки
     */
    public void EmployDown() {
        emp--;
    }

    /**
     * Возвращает количество свободных ячеек загрузки мастера по данной специализации
     * -1 если не владеет ею
     * @param kod
     * @return
     */
    public int isCan(int kod) {
        int i;
        for (i = 0; i < KOD.length; i++) {
            if (KOD[i] == kod) {
                return (empMAX - emp);
            }
        }
        return -1;
    }

    /**
     * @return Возвращает имя
     */
    public String getName() {
        return name;
    }

    /**
     * @return возвращает специализации
     */
    public int[] getKOD() {
        return KOD;
    }

    /**
     * @return возвращает текущую загрузку
     */
    public int getEmp() {
        return emp;
    }

    /**
     * @return возвращает максимальную загрузку
     */
    public int getEmpMAX() {
        return empMAX;
    }

    /**
     * Метод сравнения с другим мастером
     * Ведётся по имени
     * @param o
     * @return
     */
    public int compareTo(Master o) {
        return name.compareTo(o.getName());
    }

    /**
     * Возвращает истину, если имена совпадают
     * @param o
     * @return
     */
    public boolean equals(Master o) {
        if (name.equals(o.getName())) {
            return true;
        }
        return false;
    }
}
