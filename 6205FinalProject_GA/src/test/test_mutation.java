package test;

import INfO6205FinalProject.Evolution.FirstGeneration;
import INfO6205FinalProject.Evolution.Mutation;
import INfO6205FinalProject.GeneGenotype.Cities;
import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_mutation {
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
}
