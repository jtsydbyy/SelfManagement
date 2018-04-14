/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.FundProduct.FundProduct;
import Business.FundProduct.FundProductDirectory;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author yangyun
 */
public class FundCompany extends Enterprise {
    private FundProductDirectory fundProductDirectory;
     public FundCompany(String name) {
        super(name, EnterpriseType.FundCompany);
        this.fundProductDirectory = new FundProductDirectory();
        Random ran = new Random();
        int count = ran.nextInt(20);
        FundProduct fp = new FundProduct();
        fp.setDescription("The New Fund");
        fp.setEnterprise(this);
        fp.setFundType(FundProduct.FundType.StockFund);
        fp.setName("FP0"+String.valueOf(count));
        fp.setPurchasePrice(100);
        fp.setPurchaseDate("11/29/2017");
        fp.setRedemptionDate("11/28/2018");
        fp.setQuantity(1000);
        fundProductDirectory.plusFundProduct(fp);
        count++;
    }

    public FundProductDirectory getFundProductDirectory() {
        return fundProductDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
