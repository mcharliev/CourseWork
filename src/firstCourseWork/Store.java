package firstCourseWork;

import java.util.Arrays;

public class Store {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Olivia Smith", 1, 1800);
        employees[1] = new Employee("Samuel Adams", 2, 1650);
        employees[2] = new Employee("Jack Peterson", 2, 1920);
        employees[3] = new Employee("George Wilson", 3, 1750);
        employees[4] = new Employee("Lily King", 4, 2100);
        employees[5] = new Employee("Patricia Mason", 4, 2250);
        employees[6] = new Employee("Diego Lopes", 5, 2350);
        employees[7] = new Employee("Connor Johnson", 1, 1700);
        employees[8] = new Employee("James Smith", 5, 1950);
        employees[9] = new Employee("Daniel Brown", 3, 2150);

//        System.out.println("Сумма затрат на зарплаты в месяц : " + findSalaryPerMonths(employees));
//        System.out.println("Сотрудник с минимальной зарплатой : " + findMinSalary(employees));
//        System.out.println("Сотрудник с максимальной зарплатой : " + findMaxSalary(employees));
//        System.out.println("Среднее значение зарплат : " + findAverageSalary(employees));
//        increaseSalary(employees, 1.15);
//        showDepartmentInfo(employees, 1);
        showSalaryInfo(employees, 1900);


    }

    public static void printAllInfo(Employee[] employee) {
        for (Employee emp : employee) {
            System.out.println(emp);
        }
    }

    public static int findSalaryPerMonths(Employee[] employee) {
        int sum = 0;
        for (int i = 0; i < employee.length; i++) {
            sum += employee[i].getSalary();
        }
        return sum;
    }

    public static Employee findMinSalary(Employee[] employee) {
        double minSalary = employee[0].getSalary();
        Employee emp = employee[0];
        for (int i = 0; i < employee.length; i++) {
            if (minSalary > employee[i].getSalary()) {
                minSalary = employee[i].getSalary();
                emp = employee[i];
            }
        }
        return emp;
    }

    public static Employee findMaxSalary(Employee[] employee) {
        double maxSalary = employee[0].getSalary();
        Employee emp = employee[0];
        for (int i = 0; i < employee.length; i++) {
            if (maxSalary < employee[i].getSalary()) {
                maxSalary = employee[i].getSalary();
                emp = employee[i];
            }
        }
        return emp;
    }

    public static int findAverageSalary(Employee[] employee) {
        return (findSalaryPerMonths(employee) / employee.length);
    }

    public static void increaseSalary(Employee[] employee, double value) {
        for (int i = 0; i < employee.length; i++) {
            employee[i].setSalary(employee[i].getSalary() * value);
        }
    }

    public static void print(Employee[] employee) {
        for (Employee emp : employee) {
            System.out.println("Employee - Name: " + emp.getName() + " salary: " + emp.getSalary() + " id: " + emp.getId());
        }
    }

    public static void showDepartmentInfo(Employee[] employee, int department) {
        Employee[] temp = new Employee[employee.length];
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                temp[index] = employee[i];
                index++;
            }
        }
        Employee[] emp = new Employee[index];
        for (int i = 0; i < emp.length; i++) {
            emp[i] = temp[i];
        }
        System.out.println(Arrays.toString(emp));
        int averageSum = (findSalaryPerMonths(emp) / emp.length);
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + findMinSalary(emp));
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + findMaxSalary(emp));
        System.out.println("Сумма затрат на зарплаты по отделу  " + findSalaryPerMonths(emp));
        System.out.println("Средняя зарплата по отделу " + averageSum);
        increaseSalary(emp, 1.15);
        print(emp);
    }

    public static void showSalaryInfo(Employee[] employee, int value) {
        Employee[] tempLessValue = new Employee[employee.length];
        Employee[] tempMoreValue = new Employee[employee.length];
        int indexLessValue = 0;
        int indexMoreValue = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < value) {
                tempLessValue[indexLessValue] = employee[i];
                indexLessValue++;
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() >= value) {
                tempMoreValue[indexMoreValue] = employee[i];
                indexMoreValue++;
            }
        }

        Employee[] employeeLessValue = new Employee[indexLessValue];
        Employee[] employeeMoreValue = new Employee[indexMoreValue];
        for (int i = 0; i < employeeLessValue.length; i++) {
            employeeLessValue[i] = tempLessValue[i];
        }
        for (int i = 0; i < employeeMoreValue.length; i++) {
            employeeMoreValue[i] = tempMoreValue[i];
        }

        System.out.println("Сотрудники с зарплатой меньше : " + value);
        print(employeeLessValue);
        System.out.println("Сотрудники с зарплатой больше : " + value);
        print(employeeMoreValue);

    }
}

