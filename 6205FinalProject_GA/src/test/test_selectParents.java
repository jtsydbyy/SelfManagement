package test;

import INfO6205FinalProject.Evolution.FirstGeneration;
import INfO6205FinalProject.Evolution.SelectParents;
import INfO6205FinalProject.GeneGenotype.Cities;
import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;
import INfO6205FinalProject.Utility.QuickSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_selectParents {
    @Test
    public void test_SelectParents1(){
        City[] a = Cities.initiate();
        Individual[] b = FirstGeneration.create(50, a);
        QuickSort.sort(b, 0, b.length-1);

        Individual[] parents = SelectParents.selectParents(b, 10);// p = 10

        //0.2 = 2 * (10 / 100) -- 2 * p%
        int n = (new Double(b.length * 0.2)).intValue();
        double[] parent_range = new double[n];
        for(int i = 0; i < n; i++){
            parent_range[i] = b[i].getWeight();
        }
        int count = 0;
        //0.06 = 60% * (10 / 100) -- 60% * p%
        for(int i = 0; i < (b.length * 0.06); i++){
            for(int j = 0; j < parent_range.length; j++){
                if(parents[i].getWeight() == parent_range[j]) count++;
            }
        }
        assertEquals(3,count);
    }

    @Test
    public void test_SelectParents2(){
        City[] a = Cities.initiate();
        Individual[] b = FirstGeneration.create(100, a);
        QuickSort.sort(b, 0, b.length-1);

        Individual[] parents = SelectParents.selectParents(b, 15);

        //0.3 = 2 * (15 / 100) --2 * p%
        int n = (new Double(b.length * 0.3)).intValue();
        double[] parent_range = new double[n];
        for(int i = 0; i < n; i++){
            parent_range[i] = b[i].getWeight();
        }
        int count = 0;
        //0.09 = 60% * (15 / 100) -- 60% * p%
        for(int i = 0; i < (b.length * 0.09); i++){
            for(int j = 0; j < parent_range.length; j++){
                if(parents[i].getWeight() == parent_range[j]) count++;
            }
        }
        assertEquals(9,count);
    }
}
