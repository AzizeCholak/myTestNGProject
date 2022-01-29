package techproed.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.utilities.Driver;

public class Day12_Assertions {
    /*/
    Hard Assertion -- It stops execution if our case fails
     */

    @Test
    public void hardAssert(){
        System.out.println("This is line 11");
        Assert.assertEquals(4,5);//False fail
        System.out.println("This is line 13");//This line isn't complied It is not running
    }


    @Test
    public void softAssert(){
        //Create an object to use it
        SoftAssert softAssert = new SoftAssert();
        System.out.println("This is line 24");
        softAssert.assertEquals(4,5);//This will fail and on the console it will be printed as FAILED
        System.out.println("This is line 26");//This line will be executed and printed on the console
        softAssert.assertTrue("java".contains("e"));//This will fail
        System.out.println("This is line 28");//This line will be executed and printed on the console
        softAssert.assertEquals(3,3);//This will pass and It will be written as PASSED
        System.out.println("This is line 30");//This line will be executed and printed on the console

        softAssert.assertAll();//Don't forget assertAll() to see failures and passed one properly


        /*/
        What is soft assertion : Verifying all test cases using softAssertion(a method imported from test NG)
        We have to create an object from SoftAssert Class(The first difference!)
        We have to add assertAll to see if there is any failure.

        What are the differences between hard assertion and soft assertion?
        I prefer hard assertions because the tests shouldn't continue running. If there is anything wrong I expect the automation to fail.
        By the way I can investigate and report it.
        Sometimes I prefer using soft assertion. When I write my initial test cases. At the end i can check what is wrong
        For many test data sometimes I should prefer to see which ones will fail, which ones will pass.
         */
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}