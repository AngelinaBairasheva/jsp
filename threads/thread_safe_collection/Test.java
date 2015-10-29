package thread_safe_collection;

/**
 * Created by SDS on 29.10.2015.
 */
public class Test {
    public static void main(String[] args) {
        final LimitedStack<String> stack=new LimitedStack(8);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                for (; ; ) {
                    counter++;
                    stack.push(String.valueOf(counter));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Object value = stack.pull();
                    System.out.println(" object: "+value);
                }
            }
        });
        thread2.start();
    }
}
