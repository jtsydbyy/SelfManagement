/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Platform;
import Business.Organization.Organization;
import Business.Organization.PlatformCustomerOrganization;
import Business.UserAccount.UserAccount;
import Interface.PlatformCustomerRole.PlatformCustomerWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author yangyun
 */
public class PlatformCustomerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PlatformCustomerWorkArea(userProcessContainer, account, (PlatformCustomerOrganization)organization, (Platform)enterprise, business);
    }
    
}
