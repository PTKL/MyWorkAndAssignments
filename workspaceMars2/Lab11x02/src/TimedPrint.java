class TimedPrint implements Runnable {
    private String words;
    private long delay;
    public TimedPrint(String words, long delay) {
        this.words = words;
        this.delay = delay;
    }
    @Override
    public void run() {
        try {
            while (true) {            
                System.out.println(this.words);
                Thread.sleep(this.delay);
            }
        } catch (InterruptedException e) {}
    }
}