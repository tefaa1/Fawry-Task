package model;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        validate();
    }

    private void validate(){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }

        if(balance < 0){
            throw new IllegalArgumentException("Customer balance cannot be less than 0");
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void reduceFromBalance(double total){
        if(total > balance){
            throw new IllegalArgumentException("Process canceled, you have no enough balance");
        }
        balance -= total;
    }
}
