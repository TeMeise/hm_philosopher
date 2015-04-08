package de.hm.vss.philosopher.threads;

import de.hm.vss.philosopher.model.Fork;
import de.hm.vss.philosopher.model.Plate;
import de.hm.vss.philosopher.model.Table;

/**
 * Created by Joncn on 08.04.2015.
 */
public class Philosopher extends Thread
{
    private final Table table;
    private final int index;

    public Philosopher(Table table, int index)
    {
        this.table = table;
        this.index = index;
    }

    public void run()
    {
        Plate plate;
        Fork leftFork;
        Fork rightFork;

        meditate();
        try
        {
            plate = table.getPlate();
            plate.wait();
            System.out.println("Philosopher " + index + " got Plate " + plate.getIndex());
            leftFork = plate.getLeftFork();
            leftFork.wait();
            rightFork = plate.getRightFork();
            rightFork.wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }



    }

    private void meditate()
    {

    }
}
