package home;

import common.Base;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by rrt on 12/26/2015.
 */
public class Search extends Base {

    @DataProvider(name = "items")
    public Object[][] createData(){
        return new Object[][]{
                {"Politics"},
                {"Tech"},
        };
    }
    @Test(dataProvider = "items")
    public void test1(String data){
        BasicConfigurator.configure();
//        logger.setLevel(Level.INFO);
//        logger.info("Cnn search test started");
        clickByCss("#search-button");
        typeByCss("#search-input-field", data);
    }
}
