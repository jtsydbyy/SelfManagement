package test;

import INfO6205FinalProject.GeneGenotype.City;
import INfO6205FinalProject.GeneGenotype.Individual;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

public class test_calculateWeight {
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


}
