package sharedbuffer;

public class SynchronizedBuffer implements Buffer
{
    private int buffer = -1;  // shared by producer and consumer threads
    private boolean hasValue; // is the buffer occupied with a value in it

    @Override
    public synchronized void set(int value) throws InterruptedException
    {
        // while buffer is occupied with a value, place thread in waiting state
        while (hasValue)
        {
            // output thread information and buffer information, the wait
            System.out.println("Producer tries to write.");
            displayState("Buffer full. Producer waits.");
            System.out.println();
            wait();
        }

        buffer = value; // set new buffer value

        // indicate that producer cannot store another value
        // until consumer retrieves the current buffer value
        hasValue = true;

        displayState("Producer writes " + buffer);

        // tell waiting thread(s) to enter runnable state
        notifyAll();
    } // end method set; release lock on SynchronizedBuffer

    @Override
    public synchronized int get() throws InterruptedException
    {
        // while there is no date to read, place thread in waiting state
        while (!hasValue)
        {
            // output thread information and buffer information, the wait
            System.out.println("Consumer tries to read.");
            displayState("Buffer empty. Consumer waits.");
            System.out.println();
            wait();
        }

        // indicate that producer can store another value
        // because consumer just retrieved the buffer value
        hasValue = false;

        displayState("Consumer reads " + buffer);

        // tell waiting thread(s) to enter runnable state
        notifyAll();

        return buffer;
    } // end method get; release lock on SynchronizedBuffer

    // display current operation and buffer state
    public void displayState(String operation)
    {
        System.out.printf(
                "%-40s%s\n",
                operation,
                hasValue ? Integer.toString(buffer) : "Empty");
    }
}