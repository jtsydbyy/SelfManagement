package test;

import INfO6205FinalProject.GeneGenotype.Individual;
import INfO6205FinalProject.Utility.QuickSort;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

public class test_sortIndividuals {
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
