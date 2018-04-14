/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.TradeInformation.TradeDirectory;

/**
 *
 * @author yangyun
 */
public class UserAccount {
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private TradeDirectory tradeDirectory;

    public UserAccount() {
        tradeDirectory = new TradeDirectory();
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public TradeDirectory getTradeDirectory() {
        return tradeDirectory;
    }

    public void setTradeDirectory(TradeDirectory tradeDirectory) {
        this.tradeDirectory = tradeDirectory;
    }
    
    @Override
    public String toString() {
        return username;
    }
}
