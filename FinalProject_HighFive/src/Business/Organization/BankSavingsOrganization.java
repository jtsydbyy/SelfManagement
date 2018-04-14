/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BankSavingsRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class BankSavingsOrganization extends Organization{

    public BankSavingsOrganization() {
        super(Organization.OrganizationType.BankSavings.getValue(), Organization.OrganizationType.BankSavings);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new BankSavingsRole());
        return roles;
    }
    
}
