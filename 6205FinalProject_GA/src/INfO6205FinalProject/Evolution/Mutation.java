package INfO6205FinalProject.Evolution;

import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;

import java.util.Random;

public class Mutation {

    //Mutation probability is p.
    public static void mutation(Individual[] ins, int p){
        int n = ins.length * p / 100;
        int count = 0;

        int j = ins.length - 1;
        int k = 0;
        for(int i = 0; i < n; i++){
            if(k > 28) k = 0;
            City[] order = ins[j].getOrder();
            int a = k;
            int b = k +1;
            City t = order[a];
            order[a] = order[b];
            order[b] = t;
            ins[j].setWeight(0);
            ins[j].calculateTotalWeight();
            k++;
            j--;
        }

//        while(count < n){
//            int index = r.nextInt(ins.length);
//            City[] muts = ins[index].getOrder();
//            int a = r.nextInt(30);
//            int b = r.nextInt(30);
//            City t = muts[a];
//            muts[a] = muts[b];
//            muts[b] = t;
//            count++;
//            //System.out.println("mut: "+index+",");
//            ins[index].setWeight(0.0);
//            ins[index].calculateTotalWeight();
//
//        }
    }
}
