/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PlatformCustomerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class PlatformCustomerOrganization extends Organization {
    public PlatformCustomerOrganization() {
        super(OrganizationType.PlatformCustomer.getValue(), OrganizationType.PlatformCustomer);
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PlatformCustomerRole());
        return roles;
    }
}
