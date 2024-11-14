import java.util.concurrent.Semaphore;
public class ReaderWriterSynchronization
{
static Semaphore readLock=new Semaphore(1);
static Semaphore writeLock=new Semaphore(1);
static int readCounter=0;

static class ReadOperation implements Runnable
{
    public void run()
    {
        try
        {
        readLock.acquire();
        readCounter++;
        if(readCounter==1)
        {
        writeLock.acquire();
        }
        readLock.release();
        
        System.out.println("\t\tThread"+Thread.currentThread().getName()+" is Reading.");
        Thread.sleep(1000);
        System.out.println("\t\tThread"+Thread.currentThread().getName()+" has finished Reading.");
        readLock.acquire();
        readCounter--;

            if(readCounter==0)
            {
            writeLock.release();
            }
            readLock.release();
        }
        catch(InterruptedException e)
        {
        System.out.println(e.getMessage());
        }
    }
}


static class WriteOperation implements Runnable
{
public void run()
{
try
{
writeLock.acquire();
System.out.println("\t\tThread"+Thread.currentThread().getName()+" is writting");
Thread.sleep(1000);
System.out.println("\t\tThread"+Thread.currentThread().getName()+" has finished writting.");
writeLock.release();
}
catch(InterruptedException e)
{
System.out.println(e.getMessage());
}
}
}
public static void main(String args[])
{
System.out.println("\t\t\n##### Reader Writer (Classical SynchronizationProblem) #####");
ReadOperation read=new ReadOperation();
WriteOperation write=new WriteOperation();
Thread thread1=new Thread(read);
thread1.setName("Thread 1");
Thread thread2=new Thread(read);
thread2.setName("Thread 2");
Thread thread3=new Thread(write);
thread3.setName("Thread 3");
Thread thread4=new Thread(read);
thread4.setName("Thread 4");
Thread thread5=new Thread(write);
thread5.setName("Thread 5");
thread1.start();
thread2.start();
thread3.start();
thread4.start();
thread5.start();
}
}
