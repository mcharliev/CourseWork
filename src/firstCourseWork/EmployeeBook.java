package firstCourseWork;

class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    public void removeEmployee(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name)) {
                employees[i] = null;
            }
        }
    }

    public void printAllInfo() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public void print(int department) {
        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                System.out.println("Employee - Name: " + emp.getName()
                        + " salary: " + emp.getSalary() + " id: " + emp.getId());
            }
        }
    }

    public int findSumOfSalary() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public int findSumOfSalaryInDep(int department) {
        Employee[] emp = getEmployeesByDepartment(department);
        int sumInDep = 0;
        for (int i = 0; i < emp.length; i++) {
            sumInDep += emp[i].getSalary();
        }
        return sumInDep;
    }

    public Employee findMaxSalary() {
        double maxSalary = employees[0].getSalary();
        Employee emp = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                emp = employees[i];
            }
        }
        return emp;
    }

    public Employee findMaxSalaryInDep(int department) {
        Employee[] emp = getEmployeesByDepartment(department);
        double maxSalaryInDep = emp[0].getSalary();
        Employee temp = emp[0];
        for (int i = 0; i < emp.length; i++) {
            if (maxSalaryInDep < emp[i].getSalary()) {
                maxSalaryInDep = emp[i].getSalary();
                temp = emp[i];
            }
        }
        return temp;
    }

    public Employee findMinSalary() {
        double minSalary = employees[0].getSalary();
        Employee emp = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                emp = employees[i];
            }
        }
        return emp;
    }

    public Employee findMinSalaryInDep(int department) {
        Employee[] emp = getEmployeesByDepartment(department);
        double minSalaryInDep = emp[0].getSalary();
        Employee temp = emp[0];
        for (int i = 0; i < emp.length; i++) {
            if (minSalaryInDep > emp[i].getSalary()) {
                minSalaryInDep = emp[i].getSalary();
                temp = emp[i];
            }
        }
        return temp;
    }

    public int findAverageSalary() {
        return (findSumOfSalary() / employees.length);
    }

    public int findAverageSalaryInDep(int department) {
        Employee[] emp = getEmployeesByDepartment(department);
        int sum = 0;
        for (int i = 0; i < emp.length; i++) {
            sum += emp[i].getSalary();
        }
        return (sum / emp.length);
    }

    public void increaseSalary(double value) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() * value);
        }
    }

    public void increaseSalaryInDep(Employee[] employee, double value) {
        for (int i = 0; i < employee.length; i++) {
            employee[i].setSalary(employee[i].getSalary() * value);
        }
    }

    public void showDepartmentInfo(int department) {
        Employee[] emp = getEmployeesByDepartment(department);
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + findMaxSalaryInDep(department));
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + findMinSalaryInDep(department));
        System.out.println("Сумма затрат на зарплаты по отделу  " + findSumOfSalaryInDep(department));
        System.out.println("Средняя зарплата по отделу " + findAverageSalaryInDep(department));
        increaseSalaryInDep(emp, 1.15);
        print(department);
    }

    public void showSalaryInfo(int value) {
        System.out.println("Сотрудники магазина зарплата у которых зарплата меньше " + value);
        for (Employee emp : employees) {
            if (emp.getSalary() < value) {
                System.out.println("Name: " + emp.getName() + " id: " + emp.getId() + " salary: " + emp.getSalary());
            }
        }
        System.out.println("Сотрудники магазина зарплата у которых зарплата  больше и равна " + value);
        for (Employee emp : employees) {
            if (emp.getSalary() >= value) {
                System.out.println("Name: " + emp.getName() + " id: " + emp.getId() + " salary: " + emp.getSalary());
            }
        }
    }

    public void changeEmployeeSalary(String name, double newSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name)) {
                employees[i].setSalary(newSalary);
            }
        }
    }

    public void changeEmployeeDep(String name, int newDep) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name)) {
                employees[i].setDepartment(newDep);
            }
        }
    }

    public void printDepartmentInfo(int dep) {
        for (Employee emp : employees) {
            if (emp.getDepartment() == dep) {
                System.out.println("Сотрудник отдела № " + dep + " " + emp.getName());
            }
        }
    }

    public Employee[] getEmployeesByDepartment(int department) {
        Employee[] temp = new Employee[employees.length];
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                temp[index] = employees[i];
                index++;
            }
        }
        Employee[] emp = new Employee[index];
        for (int i = 0; i < emp.length; i++) {
            emp[i] = temp[i];
        }
        return emp;
    }
}



