package quizEngine.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface QuizQuestionDAO extends CrudRepository<QuizQuestion, Long> {
}
