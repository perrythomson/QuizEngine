package quizEngine.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quizEngine.entities.RoleType;
import quizEngine.entities.Tester;
import quizEngine.entities.TesterDAO;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by perrythomson on 8/20/16.
 */
public class TesterController {
    private final TesterDAO testerDAO;

    @Autowired
    public TesterController(TesterDAO testerDAO) {
        Assert.notNull(testerDAO, "TesterDAO must not be null!");
        this.testerDAO = testerDAO;
    }

    @RequestMapping(value = "/testerLogin", method = RequestMethod.GET)
    public String testerLogin() {
        return "testerLogin";
    }

    @RequestMapping(value = "/testerLogin", method = RequestMethod.POST)
    public String validateLogin(String userid, String password, HttpServletRequest request, HttpServletResponse response) {
        String returnPage = "";
        Tester tester = testerDAO.findByUserId(userid);
        if (tester == null || tester.getUserID().equals(userid) == false) {//Used "== false" instead of "!" to improve readability.
            request.setAttribute("error","invalid user");
            return "testerLogin";
        }
        if (tester.getPassword().equals(password) == false) {
            request.setAttribute("error","invalid password");
            return "testerLogin";
        }
        if (tester.getRoles().contains(RoleType.ADMIN)) {
            return "admin/viewAllQuestions";
        }
        if (tester.getRoles().contains(RoleType.USER)) {
            return "quiz/index";
        }
        request.setAttribute("error","Unknown error!");
        return "testerLogin";
    }

    @RequestMapping(value="/testerLogout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("logout","logout");
        return "login";
    }
}
