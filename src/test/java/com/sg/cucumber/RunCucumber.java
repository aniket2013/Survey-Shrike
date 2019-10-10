package com.sg.cucumber;

import org.junit.runner.RunWith;
 
import cucumber.junit.Cucumber; 

@RunWith(Cucumber.class) 
@Cucumber.Options(format = {"pretty", "html: target/Dest"})
public class RunCucumber {
}
