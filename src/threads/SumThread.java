package threads;


class SumThread extends Thread {
    private long start;
    private long end;
    private long sum;

    public SumThread(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        sum = Main.sum(start, end);
    }

    public long getSum() {
        return sum;
    }
}