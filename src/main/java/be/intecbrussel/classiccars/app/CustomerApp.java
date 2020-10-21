package be.intecbrussel.classiccars.app;


import be.intecbrussel.classiccars.data.dao.ProductlineDao;
import be.intecbrussel.classiccars.data.dao.ProductlineDaoJpaImpl;
import be.intecbrussel.classiccars.entity.Productline;

import java.io.FileOutputStream;

public class CustomerApp {


    public static void main(String[] args) {

        ProductlineDao productlineDao = new ProductlineDaoJpaImpl();
        Productline productline = productlineDao.readProductLine("Classic Cars");
        System.out.println(productline);


        try(FileOutputStream fileOutputStream = new FileOutputStream("boats")){
            fileOutputStream.write(productline.getImage());
        }
        catch (Exception ex){

        }
    }


}
