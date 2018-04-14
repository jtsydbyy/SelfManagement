/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.PlatformAnalysisRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class PlatformAnalysisOrganization extends Organization {
    public PlatformAnalysisOrganization() {
        super(OrganizationType.PlatformAnalysis.getValue(), OrganizationType.PlatformAnalysis);
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PlatformAnalysisRole());
        return roles;
    }
}
