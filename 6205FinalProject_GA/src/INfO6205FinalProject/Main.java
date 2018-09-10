package INfO6205FinalProject;

import INfO6205FinalProject.Evolution.*;
import INfO6205FinalProject.GeneGenotype.Cities;
import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;
import INfO6205FinalProject.Utility.QuickSort;

public class Main {

    //M is the population of individuals in each generation.
    final static int M = 800;
    //P% is the proportion of the individuals which will be parents(of next generation) in current generation.
    final static int P = 15;
    //G is the quantity of total generations.
    final static int G = 100;
    //Q% is the probability of mutation.
    final static int Q = 20;

    //Resort after crossover and mutation.


    public static void main(String[] args) {

        //Create the first generation.
        City[] a = Cities.initiate();
        Individual[] b = FirstGeneration.create(M, a);
        QuickSort.sort(b, 0, b.length-1);

        Individual[] current = b;
        Individual[] next;

        //Evolution begins.
        for(int i = 0; i < G; i++){
            Individual[] parents = SelectParents.selectParents(current, P);
            next = NextGeneration.generate(parents, M);
            Mutation.mutation(next, Q);
            QuickSort.sort(next, 0, next.length-1);
            System.out.println("This is "+i+" generation");
            System.out.println("The best individual's phenotype/fitness in this generation is: "+next[0].getWeight());
            System.out.println("While the worst individual's phenotype/fitness in this generation is: "+next[799].getWeight());

            current = next;
        }
    }
}
