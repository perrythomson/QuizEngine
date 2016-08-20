package quizEngine.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by perrythomson on 8/20/16.
 */
public interface TesterDAO extends CrudRepository<Tester, Long> {
    TesterDAO findByEmail(String email);

}


