package threads;


class SumThread extends Thread {
    private long start;//debut de la plage par lequel le calcul commence
    private long end;//fin de la plage par lequel le calcul fini
    private long sum; //Stock la somme calculée

    public SumThread(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        sum = Main.sum(start, end);
    }//Le point d'entrée du code

    public long getSum() {
        return sum;
    }
}