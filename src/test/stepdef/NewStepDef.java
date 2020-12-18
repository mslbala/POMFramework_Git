package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Scanner;

public class NewStepDef {
    int a;
    int b;

    @Given("User is entering two numbers a and b")
    public void userIsEnteringTwoNumbersAAndB() {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
    }

    @Then("User should see the sum of the numbers entered")
    public void userShouldSeeTheSumOfTheNumbersEntered() {
        System.out.println(a+b);
    }
}
