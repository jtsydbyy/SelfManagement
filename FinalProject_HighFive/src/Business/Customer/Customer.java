/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Enterprise.Bank;
import Business.TradeInformation.Trade;
import Business.TradeInformation.TradeDirectory;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class Customer {
    private String name;
    private String userid;
    private String account;
    private Bank bank;
    private TradeDirectory tradelist;
    private String email;
    
    public Customer(){
        this.tradelist = new TradeDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    
    public TradeDirectory getTradeList(){
        return tradelist;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
