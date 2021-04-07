package top.musuixin;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.err.println(AdminMapper.getList("Select * from admin", (IRowMapper<List<Admin>>) resultSet -> {
            ArrayList<Admin> admins = new ArrayList<>();
            int i = 0;
            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setAdminId((int) resultSet.getLong(1));
                admins.add(admin);
            }
            return admins; 
        }));
    }
}
