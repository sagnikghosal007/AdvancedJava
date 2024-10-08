import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =new ThreadPoolExecutor(2,4,10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejecthandler() /*new ThreadPoolExecutor.DiscardPolicy()*/);

        for(int i=1;i<=5;i++){
            executor.submit(()->{
                try{
                    Thread.sleep(5000);
                }
                catch (Exception e){
                    //handle exception here
                }
                System.out.println("Task processed By: " +Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        }
    }

    class CustomThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread th=new Thread(r);
            th.setPriority(Thread.NORM_PRIORITY);
            th.setDaemon(false);
            return th;
        }
    }


    class CustomRejecthandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task Rejected" + r.toString());
        }
    }
