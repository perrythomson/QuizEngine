package quizEngine.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface QuizQuestionDAO extends CrudRepository<QuizQuestion, Long> {

    // category!=ALL && questionType==ALL && difficulty==ALL
    List<QuizQuestion> findByCategory(QuizQuestion.Category category);

    // category!=ALL && questionType!=ALL && difficulty==ALL
    List<QuizQuestion> findByCategoryAndQuestionType(QuizQuestion.Category category,QuizQuestion.QuestionType questionType);

    // category!=ALL && questionType!=ALL && difficulty!=ALL
    List<QuizQuestion> findByCategoryAndQuestionTypeAndDifficulty(QuizQuestion.Category category,QuizQuestion.QuestionType questionType,QuizQuestion.Difficulty difficulty);

    // category==ALL && questionType!=ALL && difficulty==ALL
    List<QuizQuestion> findByQuestionType(QuizQuestion.QuestionType questionType);

    // category==ALL && questionType!=ALL && difficulty!=ALL
    List<QuizQuestion> findByQuestionTypeAndDifficulty(QuizQuestion.QuestionType questionType,QuizQuestion.Difficulty difficulty);

    // category==ALL && questionType==ALL && difficulty!=ALL
    List<QuizQuestion> findByDifficulty(QuizQuestion.Difficulty difficulty);

    // category!=ALL && questionType==ALL && difficulty!=ALL
    List<QuizQuestion> findByCategoryAndDifficulty(QuizQuestion.Category category,QuizQuestion.Difficulty difficulty);

}