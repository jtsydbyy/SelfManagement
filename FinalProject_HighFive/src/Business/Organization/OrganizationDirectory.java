/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(OrganizationType type){
        Organization organization = null;
        if (type.getValue().equals(OrganizationType.BankTrade.getValue())){
            organization = new BankTradeOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(OrganizationType.BankSavings.getValue())){
            organization = new BankSavingsOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(OrganizationType.FundCompanyAnalysis.getValue())){
            organization = new FundCompanyAnalysisOraganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(OrganizationType.FundCompanyTrade.getValue())){
            organization = new FundCompanyTradeOraganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(OrganizationType.PlatformAnalysis.getValue())){
            organization = new PlatformAnalysisOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(OrganizationType.PlatformTrade.getValue())){
            organization = new PlatformTradeOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(OrganizationType.PlatformCustomer.getValue())){
            organization = new PlatformCustomerOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
