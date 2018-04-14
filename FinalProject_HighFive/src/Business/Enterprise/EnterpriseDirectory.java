/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.FundCompany){
            enterprise = new FundCompany(name);
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.Bank){
            enterprise = new Bank(name);
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.Platform){
            enterprise = new Platform(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
