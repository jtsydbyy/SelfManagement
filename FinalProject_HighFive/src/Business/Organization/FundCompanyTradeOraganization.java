/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FundInventoryRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class FundCompanyTradeOraganization extends Organization{
    public FundCompanyTradeOraganization() {
        super(Organization.OrganizationType.FundCompanyTrade.getValue(), Organization.OrganizationType.FundCompanyTrade);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FundInventoryRole());
        return roles;
    }
}
