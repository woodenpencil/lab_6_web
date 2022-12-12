package model.bouquet;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import model.flowers.Flowers;

/**
 * this is disc that consists of several flowers
 *
 */
public class Bouquet implements RemoteBouquet {

    public static int TOTAL_VISITORS_ON_RECEPTION = 3;

    /**
     * lock to synchronize flowers on disc
     */
    private Lock flowersLock;

    /**
     * semaphore to synchronize reception
     */
    private Semaphore receptionSemaphore;

    /**
     * list of working flowers
     */
    private List<Flowers> flowers;

    public void comeIn() throws RemoteException {
        try {
            Thread.sleep(1000);
            receptionSemaphore.acquire();
        } catch(InterruptedException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public void goOut() {
        receptionSemaphore.release();
    }

    /**
     * getter of flowers
     *
     * @return flowers list
     */
    public List<Flowers> getFlowers() {
        return flowers;
    }

    /**
     * director of disc
     */
    private BouquetManager director;

    /**
     * getter of director
     *
     * @return director
     */
    public BouquetManager getSalesman() {
        return director;
    }

    /**
     * Constructor that create flowers with flowers builder
     * @param director disc director
     */
    public Bouquet(BouquetManager director) {
        this.director = director;
        flowers = new ArrayList<>();
        flowersLock = new ReentrantLock();
        receptionSemaphore = new Semaphore(TOTAL_VISITORS_ON_RECEPTION);
    }


    /**
     * add flowers to flowers list
     *
     * @param flowers flowers to add to list
     */
    public void addFlowers(Flowers flowers) {
        flowersLock.lock();
        this.flowers.add(flowers);
        flowersLock.unlock();
    }

    /**
     * consult with the song
     *
     * @param flowers flowers that client need to consult with
     * @return true if successfully consulted with the flowers
     */
    public boolean consultWithFlowers(Flowers flowers) throws RemoteException {
        flowersLock.lock();
        boolean result = this.flowers.remove(flowers);
        flowersLock.unlock();
        return result;
    }

    /**
     * count total amount of flowers in disc
     *
     * @return totalSongsAmount
     */
    public int countTotalFlowersAmount() {
        flowersLock.lock();
        List<Flowers> curFlowers = getFlowers();
        flowersLock.unlock();
        return director.countTotalFlowersAmount(curFlowers);
    }

    /**
     * select flowers with certain age
     *
     * @param minDur minimal age of song
     * @param maxDur maximum age of song
     * @return list of flowers with defined age
     */
    public List<Flowers> selectFlowersByAge(Double minDur, Double maxDur) {
        flowersLock.lock();
        List<Flowers> curFlowers = getFlowers();
        flowersLock.unlock();
        return director.selectFlowersByDuration(curFlowers, minDur, maxDur);
    }

    /**
     * select flowers of certain salesman
     *
     * @param salesman name of the salesman whose flowers is required
     * @return list of flowers from required salesman
     */
    public List<Flowers> selectFlowersBySalesman(String salesman) {
        flowersLock.lock();
        List<Flowers> curFlowers = getFlowers();
        flowersLock.unlock();
        return director.selectFlowersBySalesman(curFlowers, salesman);
    }

    /**
     * select flowers by both parameters(salesman and below certain work age)
     *
     * @param age maximum work age
     * @param salesman name of the salesman flowers works in
     * @return list of flowers with required salesman with age below parameter
     */
    public List<Flowers> selectSpecificFlowers(double age, String salesman) {
        flowersLock.lock();
        List<Flowers> curFlowers = getFlowers();
        flowersLock.unlock();
        return director.selectSpecificFlowers(curFlowers, age, salesman);
    }


    /**
     * sort flowers by age in bouquet
     *
     * @param isReversed is list should be sorted in reversed order
     * @return sorted flowers list
     */
    public List<Flowers> sortFlowersByAge(boolean isReversed) {
        flowersLock.lock();
        List<Flowers> curFlowers = getFlowers();
        flowersLock.unlock();
        return director.sortFlowersByAge(curFlowers, isReversed);
    }

}
