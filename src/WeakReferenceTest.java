import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String... args) throws InterruptedException {
        ReferenceQueue<User> rq= new ReferenceQueue<>();
        User user= new User();
        user.name ="";
        Reference<User> r= new WeakReference<>(user,rq);
        user=null;
        System.gc();
        user=r.get();

        assert user != null;
        System.out.println(user.name);
    }
}
class User {
    String name;
}