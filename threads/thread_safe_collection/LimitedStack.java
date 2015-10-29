package thread_safe_collection;

import java.util.Stack;
public class LimitedStack<T> {
    int maxCount;

    public LimitedStack(int maxCount) {
        if (maxCount <= 0) throw new IllegalArgumentException();
        this.maxCount = maxCount;
    }

    private Stack<T> stack = new Stack<T>();
    public synchronized void push(T o)  {
        while (stack.size()==maxCount){
            try {
                System.out.println(Thread.currentThread().getName()+" waiting pulling");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stack.add(o);
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" added object: "+o);
    }

    public synchronized T pull() {
        while (stack.isEmpty()){
            try {
                System.out.println(Thread.currentThread().getName()+" waiting adding in stack");
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t=stack.pop();
        System.out.print(Thread.currentThread().getName()+"pulled ");
        return t;
    }
}
