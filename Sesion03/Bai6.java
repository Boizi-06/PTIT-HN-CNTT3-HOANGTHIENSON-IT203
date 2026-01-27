public class Bai6 {
    public static void main(String[] args) {
        int[] arrfirst = new int[] { 1, 3, 5, 7, 9 };
        int[] arrsecond = new int[] { 2, 3, 5, 6, 8, 9, 10 };
        int[] result = margeArray(arrfirst, arrsecond);
        System.out.println("Merged array: " + java.util.Arrays.toString(result));
    }

    public static int[] margeArray(int[] arrFirst, int[] arrSecond) {
        int lengthFirst = arrFirst.length;
        int lengthSecond = arrSecond.length;
        int[] arrMarge = new int[lengthFirst + lengthSecond];
        int i = 0, j = 0, k = 0;
        while (true) {
            if (i == lengthFirst && j == lengthSecond) {
                break;
            } else if (i == lengthFirst) {
                arrMarge[k] = arrSecond[j];
                j++;
                k++;
            } else if (j == lengthSecond) {
                arrMarge[k] = arrFirst[i];
                i++;
                k++;
            } else {
                if (arrFirst[i] < arrSecond[j]) {
                    arrMarge[k] = arrFirst[i];
                    i++;
                    k++;
                } else if (arrFirst[i] > arrSecond[j]) {
                    arrMarge[k] = arrSecond[j];
                    j++;
                    k++;
                } else {
                    arrMarge[k] = arrFirst[i];
                    i++;
                    j++;
                    k++;
                }
            }
        }
        int[] arrReault = new int[k];
        for (int t = 0; t < k; t++) {
            arrReault[t] = arrMarge[t];
        }
        return arrReault;

    }
}
