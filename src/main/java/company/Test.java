package company;

public class Test {
    public static void main(String[] args) {

        Director m = new Director("001","Иванов Иван",1000);
        Worker c = new Worker("002","Сидоров Олег",600);
        Worker l = new Worker("003","Зайцев Андрей",300);
        Company company = new Company(1000000);

        company.paySalary(m);
        company.paySalary(c);
        company.paySalary(l);
    }
}
