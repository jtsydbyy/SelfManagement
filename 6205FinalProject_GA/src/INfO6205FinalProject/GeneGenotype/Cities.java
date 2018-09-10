package INfO6205FinalProject.GeneGenotype;

import java.util.Random;

public class Cities {

    public static City[] initiate(){
        //Initiate an array of City.
        City[] cities = new City[30];

        Random r = new Random();

        for(int i = 0; i < 30; i++){
            cities[i] = new City(i);
        }

        cities[0].setX(1.0);
        cities[0].setY(11.0);

        cities[1].setX(6.1);
        cities[1].setY(16.1);

        cities[2].setX(23.4);
        cities[2].setY(45.6);

        cities[3].setX(24.3);
        cities[3].setY(26.7);

        cities[4].setX(31.5);
        cities[4].setY(39.5);

        cities[5].setX(56.7);
        cities[5].setY(76.5);

        cities[6].setX(99.1);
        cities[6].setY(12.3);

        cities[7].setX(42.4);
        cities[7].setY(39.0);

        cities[8].setX(11.5);
        cities[8].setY(16.3);

        cities[9].setX(12.1);
        cities[9].setY(17.1);

        cities[10].setX(92.5);
        cities[10].setY(51.5);

        cities[11].setX(21.0);
        cities[11].setY(81.0);

        cities[12].setX(12.0);
        cities[12].setY(66.1);

        cities[13].setX(38.8);
        cities[13].setY(90.1);

        cities[14].setX(22.2);
        cities[14].setY(33.6);

        cities[15].setX(51.6);
        cities[15].setY(71.2);

        cities[16].setX(95.6);
        cities[16].setY(62.3);

        cities[17].setX(31.3);
        cities[17].setY(51.1);

        cities[18].setX(61.6);
        cities[18].setY(71.2);

        cities[19].setX(16.8);
        cities[19].setY(68.7);

        cities[20].setX(77.2);
        cities[20].setY(27.2);

        cities[21].setX(41.7);
        cities[21].setY(61.7);

        cities[22].setX(29.1);
        cities[22].setY(90.0);

        cities[23].setX(80.1);
        cities[23].setY(10.0);

        cities[24].setX(12.5);
        cities[24].setY(20.7);

        cities[25].setX(28.2);
        cities[25].setY(82.6);

        cities[26].setX(44.8);
        cities[26].setY(71.2);

        cities[27].setX(99.9);
        cities[27].setY(7.0);

        cities[28].setX(85.2);
        cities[28].setY(23.4);

        cities[29].setX(42.1);
        cities[29].setY(14.7);

        return cities;
    }

}
