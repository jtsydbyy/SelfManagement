package INfO6205FinalProject.Evolution;

import INfO6205FinalProject.GeneGenotype.Individual;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SelectParents {

    //Select the parents of next generation from current generation, the number of parents is p% of current generation.
    //And these parents will be kept in the next generation.
    public static Individual[] selectParents(Individual[] a, int p){
        int number = a.length * p / 100;
        Individual[] parents = new Individual[number];

        Random r = new Random();
        Set<Integer> dpc = new HashSet<>();
        int size = dpc.size();
        Set<Integer> dpc2 = new HashSet<>();
        int size2 = dpc.size();


        //We will select 60% parents from the top (2 * p)%(based on phenotype/fitness rank) of current generation.
        int limit = (new Double(number * 0.6)).intValue();
        int bound = number * 2;

        for(int i = 0; i < limit; i++){
            while(true){
                int index = r.nextInt(bound);
                dpc.add(index);
                if(dpc.size() > size){
                    parents[i] = a[index];
                    size++;
                    break;
                }
            }
        }

        //And select the rest 40% parents from the other current generation.
        for(int i = limit; i < number; i++){
            while(true){
                int index = r.nextInt(a.length)+bound;
                if(index < a.length)
                    dpc2.add(index);
                if(dpc2.size() > size2){
                    parents[i] = a[index];
                    size2++;
                    break;
                }
            }
        }


        return parents;
    }
}
