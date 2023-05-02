public class CounterDemo {
    public static void main (String[] args){
        Counter c = new Counter();
        c.increment();
        System.out.println(c.getCount());
        c.increment(-4);
        System.out.println(c.getCount());
        int temp = c.getCount();
        c.reset();
        Counter d = new Counter(5);
        d.increment();
        System.out.println(d.getCount());
        Counter e = d;
        temp = e.getCount();
        e.increment(2);
        System.out.println(e.getCount());
    }
}
