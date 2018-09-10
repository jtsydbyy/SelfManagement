package test;

import INfO6205FinalProject.Evolution.Crossover;
import INfO6205FinalProject.Evolution.FirstGeneration;
import INfO6205FinalProject.Evolution.Mutation;
import INfO6205FinalProject.Evolution.SelectParents;
import INfO6205FinalProject.GeneGenotype.Cities;
import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;
import INfO6205FinalProject.Utility.QuickSort;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

public class Test_GA {
    @Test
    public void testCalculate1(){
        Individual in = new Individual();
        City a = new City(0);
        City b = new City(1);
        a.setX(0);
        a.setY(0);
        b.setX(3);
        b.setY(4);
        DecimalFormat df = new DecimalFormat("#.0");
        String result = df.format(in.calculateWeight(a, b));
        assertEquals("5.0", result);
    }

    @Test
    public void testCalculate2(){
        Individual in = new Individual();
        City a = new City(0);
        City b = new City(1);
        a.setX(1);
        a.setY(1);
        b.setX(4);
        b.setY(5);
        DecimalFormat df = new DecimalFormat("#.0");
        String result = df.format(in.calculateWeight(a, b));
        assertEquals("5.0", result);
    }

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

    @Test
    public void testMutation1(){
        City[] a = Cities.initiate();
        Individual[] b = FirstGeneration.create(20, a);
        double[] beforeMutation = new double[20];
        double[] afterMutation = new double[20];

        for(int i = 0; i < 20; i++){
            beforeMutation[i] = b[i].getWeight();
        }

        Mutation.mutation(b, 10);

        for(int i = 0; i < 20; i++){
            afterMutation[i] = b[i].getWeight();
        }

        boolean f = true;
        for(int i = 0; i < 20; i++){
            if(beforeMutation[i] != afterMutation[i])
                f = false;
        }

        assertEquals(false,f);
    }

    @Test
    public void testMutation2(){
        City[] a = Cities.initiate();
        Individual[] b = FirstGeneration.create(100, a);
        double[] beforeMutation = new double[100];
        double[] afterMutation = new double[100];

        for(int i = 0; i < 100; i++){
            beforeMutation[i] = b[i].getWeight();
        }

        Mutation.mutation(b, 20);

        for(int i = 0; i < 100; i++){
            afterMutation[i] = b[i].getWeight();
        }

        boolean f = true;
        for(int i = 0; i < 100; i++){
            if(beforeMutation[i] != afterMutation[i])
                f = false;
        }

        assertEquals(false,f);
    }

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

    Individual in1 = new Individual();
    Individual in2 = new Individual();
    Individual in3 = new Individual();
    Individual in4 = new Individual();

    Individual[] test = new Individual[4];

    @Test
    public void testSort1(){
        in1.setWeight(100);
        in2.setWeight(80);
        in3.setWeight(90);
        in4.setWeight(110);

        test[0] = in1;
        test[1] = in2;
        test[2] = in3;
        test[3] = in4;
        QuickSort.sort(test, 0, 3);
        DecimalFormat df = new DecimalFormat("#.0");
        String result1 = df.format(test[0].getWeight());
        String result2 = df.format(test[2].getWeight());
        assertEquals("80.0", result1);
        assertEquals("100.0", result2);

    }

    @Test
    public void testSort2(){
        in1.setWeight(12.3);
        in2.setWeight(11.2);
        in3.setWeight(119.92);
        in4.setWeight(110.09);

        test[0] = in1;
        test[1] = in2;
        test[2] = in3;
        test[3] = in4;
        QuickSort.sort(test, 0, 3);
        DecimalFormat df = new DecimalFormat("#.0");
        String result1 = df.format(test[0].getWeight());
        String result2 = df.format(test[3].getWeight());
        assertEquals("11.2", result1);
        assertEquals("119.9", result2);
    }
}
