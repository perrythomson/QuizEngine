package quizEngine.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by perrythomson on 8/20/16.
 */
@Transactional
public interface TesterDAO extends CrudRepository<Tester, Long> {
//    TesterDAO findByEmail(String email);
    Tester findByEmail(String email);
    Tester findByUserID(String userID); //used by signup/login jsp


}


