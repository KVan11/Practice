package java_core.Practice3;

public class Owner {
    private String idNumber; // must be exactly 12 digits
    private String fullName;
    private String email;

    public Owner(String idNumber, String fullName, String email) {
        if (idNumber == null || !idNumber.matches("\\d{12}")) {
            throw new IllegalArgumentException("Invalid idNumber (must be 12 digits)");
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.idNumber = idNumber;
        this.fullName = fullName == null ? "" : fullName;
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public void displayInfo() {
        System.out.println("Owner[id=" + idNumber + ", name=" + fullName + ", email=" + email + "]");
    }
}
