    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TradeInformation;

import Business.Customer.Customer;

/**
 *
 * @author yangyun
 */
public class PaymentTrade extends Trade{
    private double amount;
    private Customer customer;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public PaymentTrade(TradeType tt){
        super(tt);
        
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
