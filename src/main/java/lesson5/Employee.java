package lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.println("name: " + name + "\nposition: " + position + "\nemail: " + email + "\nphone number: " +
                phoneNumber + "\nsalary: "+ salary + "\nage: " + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 11)
            this.phoneNumber = phoneNumber;
        else
            System.out.println("Incorrect phone number entered");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setSalary(int salary) {
        if (salary >= 0)
            this.salary = salary;
        else
            System.out.println("Incorrect salary entered");
    }

    public int getSalary() {
        return salary;
    }

    public void setAge(int age) {
        if (salary >= 0)
            this.age = age;
        else
            System.out.println("Incorrect age entered");
    }

    public int getAge() {
        return age;
    }
}
