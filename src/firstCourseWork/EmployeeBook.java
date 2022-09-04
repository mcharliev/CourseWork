package firstCourseWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public void addEmployee(Employee employee) {       //метод принимает на вход Employee,
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {                //если ячейка в массиве свободна
                employees[i] = employee;               //добавляю в нее Employee
                break;                                 // прерываю цикл, чтобы не заполнить све ячейки одним и тем же Employee
            }
        }
    }

    public void removeEmployee(String name) {      //метод принимает на вход String,
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name)) {  //с помощью equals выясняю, равен ли геттер со String из параметра
                employees[i] = null;                    //если да, присваиваю этой ячейки null
            }
        }
    }

    public void printAllInfo() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public void print(Employee[] employee) {  //сделал отдельный метод print, так как выполнить условие
        for (Employee emp : employee) {       // №7 "Напечатать всех сотрудников отдела (все данные, кроме отдела)"
            System.out.println("Employee - Name: " + emp.getName()
                    + " salary: " + emp.getSalary() + " id: " + emp.getId());
        }
    }

    public int findSumOfSalary() {    //метод находит сумму всех зарплат во всем магазине, так как работает
        int sum = 0;                  // c приватным массивом Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public int findSumOfSalaryInDep(Employee[] employee) { //не придумал ничего лучше, как создать отдельный метод для
        int sumInDep = 0;                          //нахождения суммы зарплат в отделе, так как метод findSumOfSalary()
        for (int i = 0; i < employee.length; i++) { // для этой целе не подходит, так как он работает напрямую работает
            sumInDep += employee[i].getSalary();  // с массивом  Employee[] employees = new Employee[10]; из 9 строки
        }
        return sumInDep;
    }

    public Employee findMaxSalary() {               //метод находит максимальную зарплату сотрудника во всем магазине, так как работает
        double maxSalary = employees[0].getSalary();  // c приватным массивом Employee[] employees = new Employee[10];
        Employee emp = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                emp = employees[i];
            }
        }
        return emp;
    }

    public Employee findMaxSalaryInDep(Employee[] employee) { // тут тоже не придумал ничего лучше, как создать отдельный метод для
        double maxSalaryInDep = employee[0].getSalary();     //нахождения максимальной зарплаты сотрудника в отделе, так как метод findMaxSalary()
        Employee emp = employee[0];                          //для этой целе не подходит, так как он работает напрямую
        for (int i = 0; i < employee.length; i++) {          // с массивом  Employee[] employees = new Employee[10]; из 9 строки
            if (maxSalaryInDep < employee[i].getSalary()) {
                maxSalaryInDep = employee[i].getSalary();
                emp = employee[i];
            }
        }
        return emp;
    }

    public Employee findMinSalary() {       //метод находит минимальную зарплату сотрудника во всем магазине, так как работает
        double minSalary = employees[0].getSalary(); // c приватным массивом Employee[] employees = new Employee[10];
        Employee emp = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                emp = employees[i];
            }
        }
        return emp;
    }

    public Employee findMinSalaryInDep(Employee[] employee) { // тут тоже не придумал ничего лучше, как создать отдельный метод для
        double minSalaryInDep = employee[0].getSalary();    //нахождения минимальной зарплаты сотрудника в отделе, так как метод findMinSalary()
        Employee emp = employee[0];                        //для этой целе не подходит, так как он работает напрямую
        for (int i = 0; i < employee.length; i++) {        // с массивом  Employee[] employees = new Employee[10]; из 9 строки
            if (minSalaryInDep > employee[i].getSalary()) {
                minSalaryInDep = employee[i].getSalary();
                emp = employee[i];
            }
        }
        return emp;
    }

    public int findAverageSalary() {             //метод находит среднее значение всех зарплат в магазине работает напрямую
        return (findSumOfSalary() / employees.length); // c приватным массивом Employee[] employees = new Employee[10];
    }

    public int findAverageSalaryInDep(Employee[] employee) {  // тут тоже пришлось делать отдельный метод,
        return (findSumOfSalaryInDep(employee) / employee.length); // все по тем же причинам
    }

    public void increaseSalary(double value) {   //метод индексирует зарплату работает напрямую c приватным массивом Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() * value);
        }
    }

    public void increaseSalaryInDep(Employee[] employee, double value) { // тут тоже пришлось делать отдельный метод,
        for (int i = 0; i < employee.length; i++) {                     // все по тем же причинам
            employee[i].setSalary(employee[i].getSalary() * value);
        }
    }

    public void showDepartmentInfo(int department) {
        Employee[] temp = new Employee[employees.length];  //созданию временной хранилище Employee с длинной employees.length
        int index = 0;                                     //так как заранее мне неизвестно сколько будет сотрудников в запрашиваемом отделе
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                temp[index] = employees[i];               // кладу в массив temp найденных сотрудников
                index++;
            }
        }
        Employee[] emp = new Employee[index]; //перезаписавыю сотрудников в другой массив, так как в массиве temp
        for (int i = 0; i < emp.length; i++) { //есть ячейки с null, после перезаписи получается массив без null
            emp[i] = temp[i];
        }
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + findMaxSalaryInDep(emp));
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + findMinSalaryInDep(emp));
        System.out.println("Сумма затрат на зарплаты по отделу  " + findSumOfSalaryInDep(emp));
        System.out.println("Средняя зарплата по отделу " + findAverageSalaryInDep(emp));
        increaseSalaryInDep(emp, 1.15);
        print(emp);
    }

    public void showSalaryInfo(int value) {
        Employee[] tempLessValue = new Employee[employees.length]; //созданию временной хранилище Employee с зарплатой ниже чем в параметре
        int indexLessValue = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < value) {
                tempLessValue[indexLessValue] = employees[i]; //кладу сотрудников с зарплатой ниже чем в параметре в массив tempLessValue
                indexLessValue++;
            }
        }
        Employee[] tempMoreValue = new Employee[employees.length]; //созданию временной хранилище Employee с зарплатой выше чем в параметре
        int indexMoreValue = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= value) {
                tempMoreValue[indexMoreValue] = employees[i]; //кладу сотрудников с зарплатой выше чем в параметре в массив tempLessValue
                indexMoreValue++;
            }
        }
        Employee[] employeeLessValue = new Employee[indexLessValue];  //перезаписавыю сотрудников в другой массив, так как в массиве tempLessValue
        for (int i = 0; i < employeeLessValue.length; i++) {          //есть ячейки с null, после перезаписи получается массив без null
            employeeLessValue[i] = tempLessValue[i];
        }
        Employee[] employeeMoreValue = new Employee[indexMoreValue]; //перезаписавыю сотрудников в другой массив, так как в массиве tempMoreValue
        for (int i = 0; i < employeeMoreValue.length; i++) {         //есть ячейки с null, после перезаписи получается массив без null
            employeeMoreValue[i] = tempMoreValue[i];
        }
        System.out.println("Сотрудники с зарплатой меньше : " + value);
        print(employeeLessValue);                                     //вывожу информацию о сотрудиках, у которых зарплата меньше чем в параметре
        System.out.println("Сотрудники с зарплатой больше или равно : " + value);
        print(employeeMoreValue);                                      //вывожу информацию о сотрудиках, у которых зарплата больше чем в параметре
    }

    public void changeEmployeeSalary(String name) throws IOException {   // в этом методе не придумал ничего лучше, как
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // изменить зарплату сотрудника с помощью вводу в консоль
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name)) {
                System.out.print("Измените зарплату работника "+ employees[i].getName() + ": ");
                employees[i].setSalary(Integer.parseInt(reader.readLine()));
                System.out.println("Зарплату работника " + employees[i].getName() + " изменена на "
                        + employees[i].getSalary());
            }
        }
    }

    public void changeEmployeeDep(String name) throws IOException {       // в этом методе не придумал ничего лучше, как
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // изменить отдел сотрудника с помощью вводу в консоль
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name)) {
                System.out.print("Измените отдел работника "+ employees[i].getName() + ": ");
                employees[i].setDepartment(Integer.parseInt(reader.readLine()));
                System.out.println("Отдел работника " + employees[i].getName() + " изменен на "
                        + employees[i].getDepartment());
            }
        }
    }

    public void printDepartmentInfo(int dep) {
        for(Employee emp:employees){
            if (emp.getDepartment()==dep){
                System.out.println("Сотрудник отдела № " + dep + " " + emp.getName());
            }
        }
    }
}



