package INfO6205FinalProject.Evolution;

import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FirstGeneration {

    //Create first Generation -- M individuals.
    public static Individual[] create(int M, City[] cities){
        Random r = new Random();
        Set<Integer> dpc;
        City[] order;
        Individual[] individuals;
        individuals = new Individual[M];

        for(int i = 0; i < M; i ++){
            int j = 0;
            dpc = new HashSet<>();
            order = new City[30];

            while(dpc.size() < 30){

                int t = dpc.size();

                int index = r.nextInt(30);
                dpc.add(index);
                if(dpc.size() > t){
                    order[j] = cities[index];
                    j++;
                }
            }

            individuals[i] = new Individual();
            individuals[i].setOrder(order);
            individuals[i].calculateTotalWeight();

        }
        return individuals;
    }
}
