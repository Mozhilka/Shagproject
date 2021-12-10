package company;

class Company implements Money{

    private double totalMoney;

    @Override
    public void paySalary(Employee emp) {
        totalMoney -= emp.getSalary();
        System.out.println("выдать "+emp.getName()+" зарплату в сумме "+emp.getSalary()+" Остаток компании:"+totalMoney+" на декабрь");
    }

    public Company() {
    }
    public Company(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
