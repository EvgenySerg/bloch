public class MemoreLeaks {

    public static void main(String[] args) throws InterruptedException {
        Integer[] ar = new Integer[100000];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i;
        }
        long mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Was: " + mem);

        for (int j = 0; j < 50000; j++) {
            for (int i = 0; i < ar.length; i++) {
                ar[i] = i;
            }
        }

        mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("now: " + mem);

//        for (int i = 0; i < ar.length; i++) {
//            ar[i] = null;
//
//        }

        Thread.sleep(1000000);
        mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("After null: " + mem);
    }
}
