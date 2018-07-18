import javax.jws.soap.SOAPBinding;
import java.util.*;

public class theHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "Avas");
        map.put("2", "Petr");
        map.put("3", "Givi");

        print(map);



        class User{
            int age;
            String name;

            public User(int age, String name) {
                this.age = age;
                this.name = name;
            }
        }

        List<User> list = new ArrayList<>();
        User user=new User(34, "Avas");
        list.add(user);

        Iterator<User> i = list.iterator();


        i.forEachRemaining(System.out::println);

    }

    private static void print(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("key %name, value: %name\n", key, value);
        }
    }

}
