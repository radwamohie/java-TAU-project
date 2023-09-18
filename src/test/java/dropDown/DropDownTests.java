package dropDown;

import base1.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTests extends BaseTest {

    @Test
    public  void testSelectOption(){
       var dropDownPage= homePage.clickDropDown();
       String option = "Option 1";
       dropDownPage.selectFromDropdown("Option 1");
       var selectedOptions = dropDownPage.getSelectedOptions();
       assertEquals(selectedOptions.size(),1,"incorrect number of selection");
       assertTrue(selectedOptions.contains(option),"option not selected");
    }

}
