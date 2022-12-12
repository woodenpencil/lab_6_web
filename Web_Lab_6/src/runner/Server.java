package runner;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.bouquet.*;
import util.manager.FlowerManager;
import util.builder.FlowerBuilder;


/**
 * Server class that contains disc
 */
public class Server {
    /**
     * Server main method
     *
     * @param args command line params
     */
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet(new BouquetManager());
        FlowerManager manager = new FlowerManager();
        FlowerBuilder builder = new FlowerBuilder();

        bouquet.addFlowers(manager.buildFlower(builder, "Rose", "Flowers Time"));
        builder.reset();

        bouquet.addFlowers(manager.buildFlower(builder, "Astra", "Flowers Time"));
        builder.reset();

        bouquet.addFlowers(manager.buildFlower(builder, "Carnation", "Flowers Time"));
        builder.reset();

        bouquet.addFlowers(manager.buildFlower(builder, "Dandelion", "Paks Floris"));
        builder.reset();

        bouquet.addFlowers(manager.buildFlower(builder, "Peony", "Paks Floris"));
        builder.reset();

        bouquet.addFlowers(manager.buildFlower(builder, "Orhchid", "Daflor"));
        builder.reset();

        bouquet.addFlowers(manager.buildFlower(builder, "Lily", "Daflor"));
        builder.reset();

        bouquet.addFlowers(manager.buildFlower(builder, "Cactus", "Daflor"));
        builder.reset();

        System.out.println("Create bouquet");

        try {
            RemoteBouquet stub = (RemoteBouquet) UnicastRemoteObject.exportObject(bouquet, 0);
            Registry reg = LocateRegistry.createRegistry(9001);
            reg.bind("Bouquet", stub);
            System.out.println("Register bouquet");
        } catch(RemoteException | AlreadyBoundException e) {
            System.out.println(e);
        }
    }
}
