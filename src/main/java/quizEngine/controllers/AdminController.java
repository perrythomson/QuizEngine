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

@Controller
@RequestMapping(value="/admin/")
public class AdminController {

    private final QuizQuestionDAO quizQuestionDAO;

    @Autowired
    public AdminController(QuizQuestionDAO quizQuestionDAO) {
        Assert.notNull(quizQuestionDAO, "QuizQuestionDAO must not be null!");
        this.quizQuestionDAO = quizQuestionDAO;
    }

    @RequestMapping(value="/")
    public String allQuestions(ModelMap model) {
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
        model.addAttribute("quizQuestion",quizQuestion);
        return "admin/editQuestion";
    }

    @RequestMapping(value="saveEditedQuestion")
    public View saveEditedQuestion(QuizQuestion quizQuestion) {
        quizQuestionDAO.save(quizQuestion);
        return new RedirectView("/admin/");
    }
}
