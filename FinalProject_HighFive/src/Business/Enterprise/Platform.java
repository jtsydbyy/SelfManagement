/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Customer.Customer;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class Platform extends Enterprise{
    private ArrayList<Customer> customerdirectory;
    public Platform(String name) {
        super(name, EnterpriseType.Platform);
        this.customerdirectory = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerdirectory() {
        return customerdirectory;
    }
    
    public Customer addCustomer(){
        Customer c = new Customer();
        customerdirectory.add(c);
        return  c;
    }
    
    public void plusCustomer(Customer c){
        customerdirectory.add(c);
    }
    
    public void deleteCustomer(Customer c){
        customerdirectory.remove(c);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
