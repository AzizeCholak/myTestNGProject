package techproed.test.dateprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Day16_DataProvider1 {
    /*
    Create and return a 2 D (Two Dimensional Array method )
    @DataProvider to provide data
    store data in that method
    How do we get test data
    @Test(dataProvider = "methodName")
    Note : WE can change the name by using name parameter
    @DataProvider (name = "employeeInfo")
                    {"gino.wintheiser","%B6B*q1!TH"},
                    {"dallas.batz","dOWjuXz8*es6"},
                   {"leonel.skiles","x3uvY0f8hw1T"}
     */
    @DataProvider (name = "employeeInfo")
    public Object [][] getData(){
        Object [][] employeeCredentials = {
                {"gino.wintheiser","%B6B*q1!TH"},
                {"dallas.batz","dOWjuXz8*es6"},
                {"leonel.skiles","x3uvY0f8hw1T"}
        };
        return employeeCredentials;
    }
    @DataProvider(name = "capitalsInfo")
    public Object [][] getDataCapitals(){
        Object [][] employeeCredentials = {
                {"Germany","Berlin"},
                {"France","Paris"},
                {"Turkey","Ankara"},
                {"USA","Washington"}
        };
        return employeeCredentials;
    }
    @Test(dataProvider = "capitalsInfo")
    public void getInfoCapitals(String country, String capital){
        System.out.println(country + "        |        "+ capital);
    }
    @Test(dataProvider = "employeeInfo")
    public void getInfo(String userName, String password){
        System.out.println(userName + "        |        "+ password);
    }
}