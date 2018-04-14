/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PlatformTradeOrganization;
import Business.UserAccount.UserAccount;
import Interface.PlatformTradeRole.PlatformTradeWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author yangyun
 */
public class PlatformTradeRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PlatformTradeWorkArea(userProcessContainer, account, (PlatformTradeOrganization)organization, enterprise, business);
    }
    
}
