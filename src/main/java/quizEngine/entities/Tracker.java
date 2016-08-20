package quizEngine.entities;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Table(name = "track_results")
/**
 * Created by perrythomson on 8/17/16.
 */

public class Tracker {

    private int correct;
    private int incorrect;
    private int numberOfQuestions;

    // An auto-generated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //this auto populates ID
    private long id;

    @NotNull  //forces it to be populated
    private String email;

    @NotNull
    private String name;


    // Public methods
    public Tracker() { }

    public Tracker(long id) {
        this.id = id;
    }
    public Tracker(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public int getCorrect() {
        return correct;
    }
    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }
    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}
