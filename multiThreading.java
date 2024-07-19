
/**
 * Write a description of class Threadtest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
/*class MyRunnable implements Runnable
{
    public void run()
    {
        int i=1;
        while(true)
        {
            System.out.println(i+"Hello");
            i++;
        }
    }
}*/
public class ThreadTest implements Runnable //extends Thread
{
    public void run()
    {
        int i=1;
        while(true)
        {
            System.out.println(i+"Hello");
            i++;
        }
    }  //We cannot predict how many time it will print alternatively
    
    public static void main(String[] args) {
        
        //MyThread t=new MyThread();
        ThreadTest t=new ThreadTest();
        //MyRunnable t=new MyRunnable();
        Thread th=new Thread(t);
        
        th.start();
        
        int i=1;
        while(true)
        {
            System.out.println(i+"World");
        }
        
    }
}
