/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PlatformAnalysisOrganization;
import Business.UserAccount.UserAccount;
import Interface.BankSavingsRole.BankSavingsWorkArea;
import Interface.PlatformAnalysisRole.PlatformAnalysisWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author yangyun
 */
public class PlatformAnalysisRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PlatformAnalysisWorkArea(userProcessContainer, account, (PlatformAnalysisOrganization)organization, enterprise, business);
    }
    
}
