import java.util.Objects;

public class Employee {
    String phoneNumber;
    String phoneName;

    public Employee(String phoneNumber, String phoneName) {
        this.phoneNumber = phoneNumber;
        this.phoneName = phoneName;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toPrint() {
        return "Номер телефона: " + phoneNumber + " Имя: " + phoneName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        // Предполагаем, что пара (phoneNumber, phoneName) уникальна для каждого объекта
        return phoneNumber.equals(employee.phoneNumber) && phoneName.equals(employee.phoneName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, phoneName);
    }
}