import java.io.*;
import java.util.Objects;

public class CloseableResource implements AutoCloseable {
    private static BufferedReader br;

    public static void main(String[] args) {

        try (CloseableResource c = new CloseableResource()) {
            System.out.println(CloseableResource.br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private CloseableResource() {
        try {
            br = new BufferedReader(new FileReader(Objects.requireNonNull(getClass().getClassLoader().getResource("file.txt")).getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void close() {
        try {
            br.close();
            System.out.println("closing...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
