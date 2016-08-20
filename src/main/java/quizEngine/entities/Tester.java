package quizEngine.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by perrythomson on 8/20/16.
 */
public class Tester {

    @NotNull  //forces it to be populated
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @Id  //creates users with unique id's
    private String userID;   //this allows the user to change email address if they change it and still have access to test score

    // Public methods
    public Tester() { }  //default constructor that self instantiates
                        //only needed if there are no other constructors

    public Tester(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
