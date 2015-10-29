
public class Deadlock {
    public static void main(String[] args) {
//synchrObjects();
     synchrMethods();
    }
    public static void synchrObjects() {
        A a = new A("a");
        A b = new A("b");
        Thread t1 = new Thread(new MyRun(a,b));
        Thread t2 = new Thread(new MyRun(b,a));
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
    public static void synchrMethods(){
        A a = new A("a");
        A b = new A("b");
        Thread t1 = new Thread(new MyRun1(a,b));
        Thread t2 = new Thread(new MyRun1(b,a));
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    static class A{
        String name;
        A obj2;
        public A(String name){
            this.name=name;
        }
        synchronized void methodA(A o) {
            System.out.println(Thread.currentThread().getName()+" hold object's " + this + " monitor");
            obj2 = o;
            //если раскомментировать вызов метода Thread.sleep(), программа зависает
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            obj2.methodB();
            System.out.println(Thread.currentThread().getName()+" released object's " + obj2 + " monitor");
        }

        synchronized void methodB() {
            System.out.println(Thread.currentThread().getName()+" hold object's " + this + " monitor");
        }

        @Override
        public String toString() {
            return name;
        }
    }
    public static class MyRun implements Runnable {
        private A obj1;
        private A obj2;

        public MyRun(A obj1, A obj2){
            this.obj1 = obj1;
            this.obj2 = obj2;
        }
        public void run(){
            System.out.println(Thread.currentThread().getName()+" started");
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName()+" hold object's " + obj1 + " monitor");
                //если раскомментировать вызов метода Thread.sleep(), программа зависает
                   /*try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName()+" hold object's " + obj2 + " monitor");
                }
                System.out.println(Thread.currentThread().getName()+" released object's " + obj2 + " monitor");
            }
            System.out.println(Thread.currentThread().getName()+" released object's " + obj1 + " monitor");
        }
    }
    public static class MyRun1 implements Runnable {
        private A obj1;
        private A obj2;

        public MyRun1(A obj1, A obj2){
            this.obj1 = obj1;
            this.obj2 = obj2;
        }
        public void run(){
            System.out.println(Thread.currentThread().getName()+" started");
            obj1.methodA(obj2);
            System.out.println(Thread.currentThread().getName()+" released object's " + obj1 + " monitor");
        }
    }
}
