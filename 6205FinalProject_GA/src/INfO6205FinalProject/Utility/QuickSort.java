package INfO6205FinalProject.Utility;

import INfO6205FinalProject.GeneGenotype.Individual;

public class QuickSort {
    public static int partition(Individual[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        while(true){
            while(less(a[++i].getWeight(), a[lo].getWeight())) if(i == hi) break;
            while(less(a[lo].getWeight(), a[--j].getWeight())) if(j == lo) break;
            if(i >= j) break;
            exc(a, i, j);

        }
        exc(a, lo, j);
        return j;
    }



    public static void sort(Individual[] a, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }



    public static boolean less(double a, double b){
        return a < b;
    }

    public static void exc(Individual[] a, int i, int j){
        Individual t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
