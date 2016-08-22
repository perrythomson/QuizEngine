package quizEngine.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import quizEngine.entities.QuizQuestion;
import quizEngine.entities.QuizQuestionDAO;
import quizEngine.entities.Tracker;
import quizEngine.entities.TrackerDAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        Assert.notNull(trackerDAO, "TrackerDAO must not be null!");  //Assert extends object validates method arguments...it will not be if you do not meet my criteria
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

    @RequestMapping("uploadQuestions")         //jsp needs to be created TODO
    public String uploadQuestions() {       //passing string on to a jsp to view
        return "admin/uploadQuestions";
    }

    @RequestMapping("saveUploadedQuestions")
    public View saveUploadedQuestions(MultipartFile QuizQuestionsFile) {  //multipartfile is one of the types of things I can pass from the method
                                                                          //can be a json file or image, etc, anything that has its own stuff
                                                                          //TODO research View from signature
        String returnView = "";
        if (!QuizQuestionsFile.isEmpty()) {
            try {//(below) get current file name...get contents
//                String pathString = /Users/perrythomson/UPLOADS_Quiz_Engine/"+QuizQuestionsFile.getOriginalFilename(); //TODO create string for the try statement
                Files.write(Paths.get("/Users/perrythomson/UPLOADS_Quiz_Engine/"+QuizQuestionsFile.getOriginalFilename()),QuizQuestionsFile.getBytes());
                System.out.println("-------- File Upload Successful");
                addUploadToDatabase("/Users/perrythomson/UPLOADS_Quiz_Engine/"+QuizQuestionsFile.getOriginalFilename()); //passing the file location which need to be the same as 2 lines above
            } catch (IOException | RuntimeException e) {                    //two exceptions at once J8 short code
                e.printStackTrace();
            }
        } else {
            System.out.println("-------- File Is EMPTY!");
        }
        return new RedirectView("/admin/");
    }

    private void addUploadToDatabase(String filePath) {
        try {
            Path quizQuestionUploadedFilePath = Paths.get(filePath);
            ObjectMapper mapper = new ObjectMapper();  //map json to entities
            List<QuizQuestion> uploadedQuestions = mapper.readValue(Files.newInputStream(quizQuestionUploadedFilePath), new TypeReference<List<QuizQuestion>>(){});
            for(QuizQuestion uploadedQuizQuestion : uploadedQuestions) {  //creating new id's so that it doesn't barf and error
                QuizQuestion quizQuestion = new QuizQuestion();
                quizQuestion.setCategory(uploadedQuizQuestion.getCategory());
                quizQuestion.setQuestionType(uploadedQuizQuestion.getQuestionType());
                quizQuestion.setDifficulty(uploadedQuizQuestion.getDifficulty());
                quizQuestion.setQuestion(uploadedQuizQuestion.getQuestion());
                quizQuestion.setCorrectMultipleChoiceAnswer(uploadedQuizQuestion.getCorrectMultipleChoiceAnswer());
                quizQuestion.setWrongMultipleChoiceAnswer1(uploadedQuizQuestion.getWrongMultipleChoiceAnswer1());
                quizQuestion.setWrongMultipleChoiceAnswer2(uploadedQuizQuestion.getWrongMultipleChoiceAnswer2());
                quizQuestion.setWrongMultipleChoiceAnswer3(uploadedQuizQuestion.getWrongMultipleChoiceAnswer3());
                quizQuestion.setTrueOrFalse(uploadedQuizQuestion.isTrueOrFalse());
                quizQuestion.setCodeLines(uploadedQuizQuestion.getCodeLines());
                quizQuestionDAO.save(quizQuestion);
            }
        } catch (IOException ioe) {
            System.out.println("Issue reading List from JSON file");
            ioe.printStackTrace();
        }
    }

}
