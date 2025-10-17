package Module_6;
/*
 * ------------------------------------------------------------
 * Program: ComposerApp (Assignment 6.2)
 * File: MemComposerDao.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-10-17
 * Description:
 * In-memory implementation of ComposerDao seeded with five composers.
 * ------------------------------------------------------------
 */

import java.util.*;
import java.util.ArrayList;
import java.util.List;
public class MemComposerDao implements ComposerDao {
    //private data fields: list of composer objects
    private final List<Composer> composers;

    //no argument constructor that initializes the list of composers with five composers
    public MemComposerDao() {
        composers = new ArrayList<>();
        composers.add(new Composer(1001, "Ludwig van Beethoven", "Classical"));
        composers.add(new Composer(1002, "Johann Sebastian Bach", "Baroque"));
        composers.add(new Composer(1003, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1004, "Frédéric Chopin", "Romantic"));
        composers.add(new Composer(1005, "Duke Ellington", "Jazz"));
    }//end constructor

    /**
     * Returns an unmodifiable list of all composers.
     * @return a read only view of the list of composers
     */
    @Override
    public List<Composer> findAll() {
        return Collections.unmodifiableList(composers);
    }//end findAll

    /**
     * Searches for a composer by id.
     * @param id the id of the composer numeric id
     * @return the composer with the matching id or null if not found
     */
    @Override
    public Composer findBy(Integer id) {
        if (id == null) return null;
        for (Composer c : composers) {
            if (c.getId() == id) {
                return c;
            }//end if
        }//end for
        return null;
    }//end findBy

    /**
     * inserts a composer into the list of composers.
     * @param entity the composer to be inserted
     */
    @Override
    public void insert(Composer entity) {
        if (entity != null) {
            composers.add(entity);
        }
    }
}
