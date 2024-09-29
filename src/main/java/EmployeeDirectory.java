import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {

    public static List<Employee> directory = new ArrayList<>();

    public static List<Employee> addEmployee(Employee employee) {
        directory.add(employee);
        return directory;
    }

    public static List<Employee> delEmployee(Employee employee) {
        directory.remove(employee);
        //directory.remove(text2);
        return directory;
    }

    public static String printEmployee(String key) {
        return String.valueOf(directory.get(Integer.parseInt(key)));
    }

    public static void rePaint() {
        for (int i = 0; i < directory.size(); i++) {
            System.out.println(directory.get(i).toPrint());
        }
    }
}