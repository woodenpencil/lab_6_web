package model.bouquet;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.flowers.Flowers;


/**
 * interface that give RMI methods from disc service
 */
public interface RemoteBouquet extends Remote {

    /**
     * come to disc
     *
     */
    void comeIn() throws RemoteException;

    /**
     * go out from disc
     *
     */
    void goOut() throws RemoteException;

    /**
     * return songs of the disc
     *
     * @return songs list
     */
    List<Flowers> getFlowers() throws RemoteException;

    /**
     * return disc director
     *
     * @return director
     */
    BouquetManager getSalesman() throws RemoteException;

    /**
     * count total amount of songs in disc
     *
     * @return totalSongsAmount total amount of songs in disc
     */
    int countTotalFlowersAmount() throws RemoteException;

    /**
     * consult with the employee
     *
     * @param flowers songs that client need to consult with
     * @return true if successfully consulted with the songs
     */
    boolean consultWithFlowers(Flowers flowers) throws RemoteException;

    /**
     * sort songs by work age in disc
     *
     * @param isReversed is list should be sorted in reversed order
     * @return sorted songs list
     */
    List<Flowers> sortFlowersByAge(boolean isReversed) throws RemoteException;

    /**
     * select songs by both parameters(salesman and below certain work age)
     *
     * @param age maximum work age
     * @param salesman name of the salesman songs works in
     * @return list of songs with required salesman with age below parameter
     */
    List<Flowers> selectSpecificFlowers(double age, String salesman) throws RemoteException;

    /**
     * select songs of certain salesman
     *
     * @param salesman name of the salesman whose songs is required
     * @return list of songs from required salesman
     */
    List<Flowers> selectFlowersBySalesman(String salesman) throws RemoteException;

    /**
     * select songs with certain age
     *
     * @param minAge minimal years of work
     * @param maxAge maximum years of work
     * @return list of songs with defined age
     */
    List<Flowers> selectFlowersByAge(Double minAge, Double maxAge) throws RemoteException;
}
