/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FundAnalysisRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class FundCompanyAnalysisOraganization extends Organization{
    public FundCompanyAnalysisOraganization() {
        super(Organization.OrganizationType.FundCompanyAnalysis.getValue(), Organization.OrganizationType.FundCompanyAnalysis);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FundAnalysisRole());
        return roles;
    }
}
