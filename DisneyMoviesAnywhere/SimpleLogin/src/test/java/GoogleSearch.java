import Util.DataRead;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by PlayBoy on 6/24/16.
 */
public class GoogleSearch extends SimpleLoginCore{
    @Test
    public void googleSearch() throws InterruptedException, IOException{


        navigateToURL("www.bing.com");

        DataRead dr = new DataRead("/SimpleLogin/SourceData/chaseSearchData.xlsx");//reads search items from xcel
        int x = dr.getRowCount("Search");
        for (int i = 2; i <= x; i++) {

            sendKeysByCss("#sb_form_q", dr.getCellData("Search", "Search Item",i));
            clearInputBoxByCss("#sb_form_q");
            sleep(2);
        }
    }
}
