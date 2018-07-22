import java.lang.ref.Cleaner;

public class InstanceAroundResourceUsingCleaner implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();
    //static to not have reference to external instance private static class EncapsulatedResource implements Runnable{
    private static class EncapsulatedResource implements Runnable {
        private String handleToSystemResource; //don't need to be private because EncapsulatedResource is private

        EncapsulatedResource(String handleTosystemResource) {
            this.handleToSystemResource = handleTosystemResource;
        }

        @Override
        public void run() {
            System.out.println("Closing system resource by cleaner :" + handleToSystemResource);
            handleToSystemResource = "CLOSED";
        }
    }

    private final EncapsulatedResource state;

    private final Cleaner.Cleanable cleanable;

    public InstanceAroundResourceUsingCleaner(String resourceId) {
        this.state = new EncapsulatedResource("[opened :" + resourceId + "]");
        this.cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        System.out.println("First In Auto-Closable");
        cleanable.clean();
    }

    public static void main(String[] args) {
        try (InstanceAroundResourceUsingCleaner r = new InstanceAroundResourceUsingCleaner("BLOG-POST")) {
            System.out.println("Using resource1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new InstanceAroundResourceUsingCleaner("UNHANDLED-RESOURCE");
        System.out.println("r2 left alone");
//System.gc();
    }
}