package entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String userName;
    private String pass;
    private String role;

    public static List<User> listus = new ArrayList<>();

    static {
        listus.add(new User("dungdz11","dung123" ,"admin"));
        listus.add(new User("dungnaph49581" , "dung123" , "staff"));
        listus.add(new User("staff2","staff123","staff"));
    }

}
