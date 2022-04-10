public class App {

    public static final int NUM_TESTS = 6000; // ~30 mins
    public static void main(String[] args) throws Exception {
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < numberOfProcessors; i++)
            new Thread(() -> simulateWork()).start();
    }

    private static void simulateWork() {
        for (int i = 0; i < NUM_TESTS; i++)
            spin(500);
    }

    private static void spin(int milliseconds) {
        long sleepTime = milliseconds * 1000000L; // convert to nanoseconds
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < sleepTime) {}
    }
}
