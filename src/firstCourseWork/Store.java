package firstCourseWork;

public class Store {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee(new Employee("Olivia Smith", 1, 1800));
        employeeBook.addEmployee(new Employee("Samuel Adams", 2, 1650));
        employeeBook.addEmployee(new Employee("Jack Peterson", 2, 1920));
        employeeBook.addEmployee(new Employee("George Wilson", 3, 1750));
        employeeBook.addEmployee(new Employee("Lily King", 4, 2100));
        employeeBook.addEmployee(new Employee("Patricia Mason", 4, 2250));
        employeeBook.addEmployee(new Employee("Diego Lopes", 5, 2350));
        employeeBook.addEmployee(new Employee("Connor Johnson", 1, 1700));
        employeeBook.addEmployee(new Employee("James Smith", 5, 1950));
        employeeBook.addEmployee(new Employee("Daniel Brown", 3, 2150));

//        employeeBook.increaseSalary(1.15);
        System.out.println("Выводим всю информацию по сотрудниками всего магазина");
        System.out.println("______________________________________________________");
        employeeBook.printAllInfo();
        System.out.println("______________________________________________________");

        System.out.println("Выводим всю информацию по зарплатам всего магазина");
        System.out.println("______________________________________________________");
        System.out.println("Сумму затрат на зарплаты всех сотрудником магазина в месяц: "
                + employeeBook.findSumOfSalary());
        System.out.println("Сотрудник с минимальной зарплатой во всем магазине: "
                + employeeBook.findMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой во всем магазине: "
                + employeeBook.findMaxSalary());
        System.out.println("Среднее значение зарплат всего магазина: "
                + employeeBook.findAverageSalary());
        System.out.println("______________________________________________________");

        System.out.println("Выводим всю информацию по одному отделу магазина");
        System.out.println("______________________________________________________");
        employeeBook.showDepartmentInfo(1);
        System.out.println("______________________________________________________");

        System.out.println("Узнаем у кого из сотрудников зарплата больше или меньше исходной");
        System.out.println("______________________________________________________");
        employeeBook.showSalaryInfo(1750);
        System.out.println("______________________________________________________");

        employeeBook.changeEmployeeSalary("Diego Lopes", 2500);
        employeeBook.changeEmployeeDep("Diego Lopes", 1);
        employeeBook.printDepartmentInfo(1);
        employeeBook.increaseSalary(1.15);
    }
}



