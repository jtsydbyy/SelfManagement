package test;

import INfO6205FinalProject.Evolution.Crossover;
import INfO6205FinalProject.Evolution.FirstGeneration;
import INfO6205FinalProject.GeneGenotype.Cities;
import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;
import INfO6205FinalProject.Utility.QuickSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_crossover {

    //Check whether the children's city arrays have 30 different cities.
    @Test
    public void testCrossover1(){
        City[] a = Cities.initiate();
        Individual[] b = FirstGeneration.create(20, a);
        QuickSort.sort(b, 0, b.length-1);

        Individual chil;
        chil = Crossover.crossover(b[0],b[1]);

        boolean f = true;
        City[] chil_order = chil.getOrder();
        for(int i = 0; i < 30; i++){
            for(int j = i + 1; j < 30; j++){
                if(chil_order[i].getId() == chil_order[j].getId())
                    f = false;
            }

        }
        assertEquals(true,f);
    }

    //Check the child's first half genotype is same with first parent.
    @Test
    public void testCrossover2(){
        City[] a = Cities.initiate();
        Individual[] b = FirstGeneration.create(20, a);
        QuickSort.sort(b, 0, b.length-1);

        Individual chil;
        chil = Crossover.crossover(b[0],b[1]);

        City[] chil_order = chil.getOrder();
        City[] par_order = b[0].getOrder();
        boolean f = true;
        for(int i = 0; i < 15; i++){
            if(chil_order[i].getId() != par_order[i].getId()) f = false;
        }
        assertEquals(true, f);
    }
}
