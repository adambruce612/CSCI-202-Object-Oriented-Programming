package sharedbuffer;

public interface Buffer
{
    // place int value into the buffer
    void set(int value) throws InterruptedException;

    // get int value from the buffer
    int get() throws InterruptedException;
}