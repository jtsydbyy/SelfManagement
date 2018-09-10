package INfO6205FinalProject.Evolution;

import INfO6205FinalProject.GeneGenotype.Individual;
import java.util.Random;

public class NextGeneration {
    public static Individual[] generate(Individual[] parents, int M){
        int p = parents.length;
        int n = M - p; //n is the quantity of children.

        Individual[] next = new Individual[n];
//        Set<Double> dpc = new HashSet<>();
//        int size =dpc.size();

        for (int i = 0; i < n; i++) {
            int r1;
            int r2;
            while(true){
                Random r = new Random();
                r1 = r.nextInt(p);
                r2 = r.nextInt(p);
                if(r1 != r2) break;
            }
            next[i] = Crossover.crossover(parents[r1], parents[r2]);

        }
        Individual[] nextGeneration = new Individual[M];
        for(int i = 0; i < p; i++){
            nextGeneration[i] = parents[i];
        }

        int j = 0;
        for(int i = p; i < M; i++){
            nextGeneration[i] = next[j++];
        }
        return nextGeneration;
    }
}
