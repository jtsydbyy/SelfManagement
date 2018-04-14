/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.TradeInformation.TradeDirectory;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public abstract class Organization {
    private String name;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    private OrganizationType organizationType;
    private TradeDirectory tradeDirectory;
    
    public enum OrganizationType{
        
        Admin("Admin Organization"), 
        BankTrade("BankTrade Organization"), BankSavings("BankSavings Organization"),
        FundCompanyTrade("FundCompanyTrade Organization"), FundCompanyAnalysis("FundCompanyAnalysis Organization"),
        PlatformTrade("PlatformTrade Organization"), PlatformAnalysis("PlatformAnalysis Organization"), PlatformCustomer("PlatformCustomer Organization"),
        Enterprise("Enterprise");
        
        private String value;
        private OrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name, OrganizationType ot) {
        this.organizationType = ot;
        tradeDirectory = new TradeDirectory();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
        this.name = name + String.valueOf(counter);
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TradeDirectory getTradeDirectory() {
        return tradeDirectory;
    }

    public void setTradeDirectory(TradeDirectory tradeDirectory) {
        this.tradeDirectory = tradeDirectory;
    }
    
    public OrganizationType getOraganizationType() {
        return organizationType;
    }

    public void setOraganizationType(OrganizationType oraganizationType) {
        this.organizationType = oraganizationType;
    }

    @Override
    public String toString() {
        return name;
    }
}
