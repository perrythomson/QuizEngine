package quizEngine.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quizEngine.entities.QuizQuestion;
import quizEngine.entities.QuizQuestionDAO;
/**
 * Created by perrythomson on 8/22/16.
 */

@RestController                 //converts objects to json but it does a lot of other things
@RequestMapping("/restData/") //Spring boot 4...global mapping for /restData/ in getAllQuestions
public class DataRestController {  //bulk processing - returns all questions in Json

    private final QuizQuestionDAO quizQuestionDAO;

    @Autowired
    public DataRestController(QuizQuestionDAO quizQuestionDAO) {
        Assert.notNull(quizQuestionDAO, "QuizQuestionDAO must not be null!");
        this.quizQuestionDAO = quizQuestionDAO;
    }

    @RequestMapping("getAllQuestions")
    public Iterable<QuizQuestion> getAllQuestions() {  //Iterable stack of quiz questions from DAO
        return quizQuestionDAO.findAll();
    }
}
