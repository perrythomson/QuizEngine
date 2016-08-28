package quizEngine.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import quizEngine.entities.Tester;
import quizEngine.entities.TesterDAO;


@Controller
@RequestMapping("/")
public class SignUpController {

    private final TesterDAO testerDAO;

    @Autowired
    public SignUpController(TesterDAO testerDAO) {
        Assert.notNull(testerDAO, "TesterDAO must not be null!");
        this.testerDAO = testerDAO;
    }

    @RequestMapping(value = "/signUp")
    public String signUp() {
        return "signUp";
    }

    @RequestMapping(value = "/register")
    public String register(String email, String name, String userID, String password, String verifiedPassword) {
        boolean goodToGo = true;
        goodToGo = verifyEmail(email);
        if (goodToGo) {
            goodToGo = verifyUserID(userID);
        }
        if (goodToGo) {
            goodToGo = verifyPassword(password, verifiedPassword);
        }
        if (goodToGo) {
            Tester tester = new Tester(email, name, userID, password);
            testerDAO.save(tester);
            return "/quiz/index";
        } else {
            return "signUp";
        }
    }

     private boolean verifyEmail(String email) {
        boolean verified = true;
        verified = (email.indexOf('@') > 0);
        if (verified) {
            verified = (email.charAt(email.length()-5) == '.');
        }
        return verified;
     }

     private boolean verifyUserID(String userID) {
         Tester tester = testerDAO.findByUserID(userID); //not sure if this returns a null object or an empty one
         if(tester != null && tester.getUserID().equals(userID)) {
            return false;
         } else {
            return true;
         }
     }

     private boolean verifyPassword(String password, String verifiedPassword) {
         //TODO: separate password validation so correct issue can be reported to the user.
          if (password.length() > 4 && password.equals(verifiedPassword)) {
              return true;
          } else {
              return false;
          }
     }

}


