package stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class Sample {
    int c;

    @Given("User wants to find the sum of {int} and {int}")
    public void userWantsToFindTheSumOfAnd(int arg0, int arg1) {

        c = arg0 + arg1;
    }

    @Then("User should get the result {int}")
    public void userShouldGetTheResult(int arg0) {
        Assert.assertEquals(c, arg0);
    }

    @Given("User wants to find the sum of below numbers")
    public void userWantsToFindTheSumOfBelowNumbers(DataTable dataTable) {
        List<String> strings = dataTable.asList();
        int input1=Integer.parseInt(strings.get(0));
        int input2=Integer.parseInt(strings.get(1));
        c=input1+input2;
        System.out.println("value of c-->"+c);
    }
}
