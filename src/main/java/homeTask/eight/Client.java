package homeTask.eight;

public class Client extends People{

    private final String bankName;

    public Client(String firstName, String lastName, String bankName) {
        super(firstName, lastName);
        this.bankName = bankName;
    }

    @Override
    public String getInfo() {
        return "Client{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName()+ '\'' +
                ", bankName='" + bankName+ '\'' +
                '}';
    }

}
