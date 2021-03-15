package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Egorova Lizaveta", "manager", "egorova@box.ru",
                "89267542340", 47000, 32);
        employees[1] = new Employee("Vahetov Anton", "engineer", "vahetov@box.ru",
                "89034605871", 72000, 42);
        employees[2] = new Employee("Kopteeva Svetlana", "director", "kopteeva@box.ru",
                "89256786897", 80000, 45);
        employees[3] = new Employee("Shishanin Sergey", "manager", "shishanin@box.ru",
                "89162435392", 51000, 28);
        employees[4] = new Employee("Yanin Georgy", "engineer", "yanin@box.ru",
                "89252340817", 70000, 39);

        for (int i = 0; i < employees.length; i++){
            if(employees[i].getAge() > 40){
                employees[i].printInfo();
            }
        }

    }
}
