package runner;

import model.bouquet.RemoteBouquet;
import model.flowers.Flowers;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 * Client class which work with rmi methods of disc
 */
public class Client {

    /**
     * Client main method
     *
     * @param args command line params
     */
    public static void main(String[] args) {
        Registry reg;
        RemoteBouquet stub;

        try {
            reg = LocateRegistry.getRegistry(9001);
            stub = (RemoteBouquet)reg.lookup("Bouquet");
        } catch(RemoteException | NotBoundException e) {
            System.out.println(e);
            return;
        }

        int opNum = 3; // Experiments here
        try {
            System.out.println("I opened the bouquet");
            stub.comeIn();
            List<Flowers> flowers = stub.getFlowers();
            printFlowersList("BOUQUET FULL FLOWER LIST", flowers);
            List<Flowers>  detFlowers;
            switch(opNum) {
                case 0:
                    detFlowers = stub.selectSpecificFlowers(5.6, "Flowers Time");
                    printFlowersList("Specific flower", detFlowers);
                    break;
                case 1:
                    detFlowers = stub.selectFlowersBySalesman("Flowers Time");
                    printFlowersList("Flowers from salesman Flowers Time", detFlowers);
                    break;
                case 2:
                    detFlowers = stub.selectFlowersByAge(1.0, 5.0);
                    printFlowersList("Flowers with age between 1 and 5 days", detFlowers);
                    break;
                case 3:
                    detFlowers = stub.sortFlowersByAge(true);
                    printFlowersList("Flowers list sorted by age IN REVERSED ORDER", detFlowers);
                    break;
                case 4:
                    detFlowers = stub.sortFlowersByAge(false);
                    printFlowersList("Flowers list sorted by age", detFlowers);
                    break;
                case 5:
                    int flowersAmount = stub.countTotalFlowersAmount();
                    System.out.println("Total amount of flowers in bouquet : " +  flowersAmount);
                    return;
                default:
                    detFlowers = flowers;
            }
        } catch (RemoteException e) {
            System.out.println(e);
        } finally {
            try {
                stub.goOut();
            } catch(RemoteException e) {
                System.out.println(e);
            }
            System.out.println("End of query.");
        }
    }

    /**
     * method to display info about all songs in disc
     * @param header that determines info for user
     * @param flowerList list of described songs
     */
    public static void printFlowersList(String header, List<Flowers> flowerList) {
        System.out.println("\n =========== " + header + " =========== ");
        if(flowerList.size() > 0) {
            for(Flowers flowers : flowerList) {
                System.out.println("\n" + flowers);
            }
        }
        else {
            System.out.println("No flowers.");
        }
    }
}
