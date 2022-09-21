public class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerID() {
        return this.customer.getId();
    }

    public String getCustomerName() {
        return this.customer.getName();
    }

    public int getCustomerDiscount() {
        return this.customer.getDiscount();
    }

    public double getAmountAfterDiscount() {
        return this.amount * (100 - this.getCustomerDiscount())/ 100;
    }

    public String toString() {
        // String str = "Invoice[id=" + this.id + ",customer=" + this.customer.toString() + ",amount=" + this.amount + "]";
        return String.format("Invoice[id=%d,%s,amount=%f]", this.id, this.customer.toString(), this.amount);
    }

    public static void main(String[] args) {
        Customer ctm = new Customer(88, "Tan Ah Teck", 10);
        System.out.println(ctm.toString());
        ctm.setDiscount(8);
        System.out.println(ctm.toString());
        System.out.println("id is: " + ctm.getId());
        System.out.println("name is: " + ctm.getName());
        System.out.println("discount is: " + ctm.getDiscount());
        Invoice an = new Invoice(101, ctm, 888.8);
        System.out.println(an.toString());
        an.setAmount(999.9);
        System.out.println("id is: " + an.getId());
        System.out.println("customer is: " + an.getCustomer().toString());
        System.out.println("amount is: " + an.getAmount());
        System.out.println("customer's id is: " + an.getCustomer().getId());
        System.out.println("customer's name is: "+an.getCustomer().getName());
        System.out.println("customer's discount is: "+an.getCustomer().getDiscount());
        System.out.println("amout after discout is: "+an.getAmountAfterDiscount());
    }
}
