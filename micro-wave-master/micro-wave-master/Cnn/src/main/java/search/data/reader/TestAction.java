package search.data.reader;

import CommonApi.Base;

/**
 * Created by rrt on 1/9/2016.
 */
public class TestAction extends Base{

    public void ClickOnSearch() {
        clickByCss("#search-button");
    }
    public void TypeOnSearch(){
        typeByCss("#search-input-field", "tech");
    }
}
