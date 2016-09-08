import org.testng.annotations.Test;

/**
 * Created by PlayBoy on 6/22/16.
 */
public class ChaseLogin extends SimpleLoginCore{
    @Test
    public void chaseLogin () throws InterruptedException{
        navigateToURL("https://www.chase.com");
        clickByCss(".header__section__item.header__section--search.icon-search");
        typeByCssThenEnter(".header__section--search__bar--search-input","90660");
        clickByCss(".chasejs-flyoutlink.chaseui-noicon");
        clickByXpath(".//*[@id='chasejs-contexthelpfloater']/div[3]/a/span/img");
        //clickByXpath(".//*[@id='logo-section']/div/div[2]/div/div/div/span/a/img");
        //typeByCss("#usr_name_home","jawadnewaj1");
        sleep(3);
        //typeByCssThenEnter("#usr_password_home","3001958a");

    }
}
