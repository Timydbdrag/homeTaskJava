package homeTask.eight;

public class Employe extends People {
    private final String bankName;

    public Employe(String firstName, String lastName, String bankName) {
        super(firstName, lastName);
        this.bankName = bankName;
    }


    @Override
    public String getInfo() {
        return "Employe{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName()+ '\'' +
                ", bankName='" + bankName+ '\'' +
                '}';
    }

}
