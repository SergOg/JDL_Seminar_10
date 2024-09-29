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
}