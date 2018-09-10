package INfO6205FinalProject.Evolution;

import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Crossover {
    public static Individual crossover(Individual a, Individual b){
        Individual children;


        //Check whether the first half genotype(city array), which is from "parent" a, has duplicated elements with
        //the second half which is from "parent" b. If it does, randomly change the duplicated elements in the second
        //half to make sure that the child's genotype doesn't have duplicated cities.
        Set<Integer> dpc = new HashSet<>();
        City[] cts1 = a.getOrder();
        City[] cts2 = b.getOrder();

        for(int i = 0; i < 15; i++)
            dpc.add(cts1[i].getId());
        for(int i = 15; i < 30; i++)
            dpc.add(cts2[i].getId());
        int size = dpc.size();

        //System.out.println(size);

        //It can hardly get two half genotypes from "parents" which don't have duplicated elements.
        //if(size == 30){}

        for(int i = 0; i < 15; i ++){
            Random r = new Random();
            for(int k = 15; k < 30; k++){
                if(cts1[i].getId() == cts2[k].getId()){
                    int change;
                    while(true){
                        int t = r.nextInt(30);
                        dpc.add(t);
                        if(dpc.size() > size){
                            change = t;
                            size++;
                            break;
                        }
                    }
                    City tp;
                    for(int j = 0; j < 15; j++){
                        if(cts2[j].getId() == change){
                            tp = cts2[j];
                            cts2[k] = tp;
                        }
                    }
                }
            }

        }

        //System.out.println(size+"&&&");



        //Combine the 2 half genotypes and get the child's genotype.
        City[] childOrder1 = new City[30];
        for(int i = 0; i < 15; i++)
            childOrder1[i] = cts1[i];
        for(int i = 15; i < 30; i++)
            childOrder1[i] = cts2[i];
        children = new Individual();
        children.setOrder(childOrder1);
        children.calculateTotalWeight();



        return children;
    }
}
