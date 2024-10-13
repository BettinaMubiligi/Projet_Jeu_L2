//Mnemoi Lina et Mubiligi Bettina groupe4

import java.util.ArrayList;

public class TestSimulation{
    public static void main(String[] args){
        //Simulation 
       ArrayList<Contenu> c = new ArrayList<Contenu>();

        Grille g = new Grille(6,5);
        Agent4 agent =new Agent4(g);        

        for(int i = 0; i < 15; i++){
            c.add(new Diamant(1));
        }

        for(int i = 0; i < 2; i++){
            c.add(new Gardien("Gardien", 1));
        }

        for(int i = 0; i < 3; i++){
            c.add(new GardienTeleportable("Gardien", 1, g));
        }

        Simulation s = new Simulation(agent, g, c, 27);
        System.out.println(s);
        s.lance(10);
        System.out.println(s);


    }



}