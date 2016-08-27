package quizEngine.entities;

//import com.sun.demo.jvmti.hprof.Tracker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by perrythomson on 8/17/16.
 */
@Transactional // this is how hibernate knows this is the helper
//an interface is a special kind of class that can not be instantiated. it can be extended from another class though.
// this dao will automatically find 1 and recieves a long, also finds all. and returns arraylists and hashmaps or just one user
//C.R.U.D. < Create, Read, Update, Delete >

public interface TrackerDAO extends CrudRepository<Tracker, Long> {

    /**
     * This method will find an Tracker instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */
    Tracker findByEmail(String email);



}
//    public Tracker findByEmail(String email); //not searching by email

