public class Employee {
    String name;
    double monthlySalary, dailySalary, insurancePay;
    boolean married;

    public Employee(String name, double salary) {
        this.name = name;
        monthlySalary = salary;
        dailySalary = monthlySalary/30;
        insurancePay = (monthlySalary/100)*23;

    }


    public String getName() {
        return name;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getDailySalary() {
        return dailySalary;
    }

    public double getInsurancePay() {
        return insurancePay;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}
