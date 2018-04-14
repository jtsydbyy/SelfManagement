/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TradeInformation;

import Business.Customer.Customer;
import Business.FundProduct.FundProduct;

/**
 *
 * @author yangyun
 */
public class PurchaseTrade extends Trade{
    private String amount;
    private Customer customer;
    private FundProduct fp;
    private int quantity;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FundProduct getFp() {
        return fp;
    }

    public void setFp(FundProduct fp) {
        this.fp = fp;
    }
    
    public PurchaseTrade(TradeType tt){
        super(tt);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
