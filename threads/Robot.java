/**
 * Created by SDS on 29.10.2015.
 */
public class Robot {
    public static class RobotEx extends Thread{
        private String name;
        static final Object lock=new Object();
        public RobotEx(String name){
            this.name=name;
        }
        @Override
        public void run(){
            for(;;){
                synchronized (lock){
                    step();
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public void step(){
            System.out.println("Step: "+name);
        }
    }

    public static void main(String[] args) {
        new Thread(new RobotEx("left")).start();
        new Thread(new RobotEx("right")).start();
    }
}
