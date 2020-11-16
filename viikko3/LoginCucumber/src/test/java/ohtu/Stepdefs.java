package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import ohtu.domain.User;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {
    App app;
    StubIO io;
    UserDao userDao;
    AuthenticationService auth;
    List<String> inputLines;
    User user;
    
    @Before
    public void setup(){
        userDao = new InMemoryUserDao();
        auth = new AuthenticationService(userDao);
        inputLines = new ArrayList<>();      
    }
    
    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
    }

    @When("username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }    
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("correct username {string} and false password {string} are entered")
    public void usernameEnter(String username, String password) {
        inputLines.add(username);
        //inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @When("false username {string} and correct password {string} are entered")
    public void PasswordEnter(String username, String password) {
        //inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Given("^command new is selected$")
    public void commandNEWSelected() throws Throwable {
        inputLines.add("new");
    }

    @When("correct username {string} and too short password {string} are entered")
    public void shortPassword(String username, String password) {

        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @When("too short username {string} and correct password {string} are entered")
    public void shortUsername(String username, String password) {

        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
            app = new App(io, auth);
            app.run();

        }

    @When("correct username {string} and no-number password {string} are entered")
    public void noNumberPassword(String username, String password) {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @When("user {string} with password {string} is created")
    public void correctUsernameAndPassword(String username, String password) {
        userDao.add(new User(username, password));

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

}

