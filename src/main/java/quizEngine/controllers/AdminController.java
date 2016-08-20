package quizEngine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import quizEngine.entities.QuizQuestion;
import quizEngine.entities.QuizQuestionDAO;
import quizEngine.entities.Tracker;
import quizEngine.entities.TrackerDAO;

@Controller
@RequestMapping(value="/admin/")
public class AdminController {

    private final QuizQuestionDAO quizQuestionDAO;  //DAO is an object that provides an abstract interface to some type of database or other persistence mechanism. By mapping application calls to the persistence layer,
                                                    // DAO provide some specific data operations without exposing details of the database
    private final TrackerDAO trackerDAO;

    @Autowired                      //marks a constructor, field, setter method or config  to be autowired by springs dependency injection
    public AdminController(QuizQuestionDAO quizQuestionDAO, TrackerDAO trackerDAO) {
        Assert.notNull(quizQuestionDAO, "QuizQuestionDAO must not be null!");  //Assert extends object validates method arguments
        this.quizQuestionDAO = quizQuestionDAO;
        Assert.notNull(trackerDAO, "TrackerDAO must not be null!");  //Assert extends object validates method arguments
        this.trackerDAO = trackerDAO;
    }

    @RequestMapping(value="/")    //Annotation for mapping web requests onto specific handler classes and/or handler methods
    public String allQuestions(ModelMap model) {
            //An Iterable is a simple representation of a series of elements that can be iterated over. It does not have any iteration state
            // such as a "current element". Instead, it has one method that produces an Iterator.
            //An Iterator is the object with iteration state. It lets you check if it has more elements using hasNext() and move to the next
            // element (if any) using next().
            //Typically, an Iterable should be able to produce any number of valid Iterators.
        Iterable<QuizQuestion> quizQuestions = quizQuestionDAO.findAll();
        model.addAttribute("quizQuestions",quizQuestions);
        return "admin/viewAllQuestions";
    }

    @RequestMapping(value="addQuestion")
    public String addQuestion(ModelMap model) {
        model.addAttribute("quizQuestion", new QuizQuestion());
        return "admin/newQuestion";
    }

    @RequestMapping(value="saveNewQuestion")
    public View saveNewQuestion(QuizQuestion quizQuestion) {
        quizQuestionDAO.save(quizQuestion);
        return new RedirectView("/admin/");
    }

    @RequestMapping(value="viewQuestion")
    public String viewQuestion(long id,ModelMap model) {
        QuizQuestion quizQuestion = quizQuestionDAO.findOne(id);
        model.addAttribute("quizQuestion",quizQuestion);  //(Object attributeValue)
        return "admin/editQuestion";
    }

    @RequestMapping(value="saveEditedQuestion")
    public View saveEditedQuestion(QuizQuestion quizQuestion) {
        quizQuestionDAO.save(quizQuestion);
        return new RedirectView("/admin/");
    }

    @RequestMapping(value="viewStats")
    public String viewStats(ModelMap testResults) {
        Iterable<Tracker> testScores = trackerDAO.findAll();
        testResults.addAttribute("testScores", testScores);
        return "admin/viewAllTests";
    }
}
