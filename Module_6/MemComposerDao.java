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
/*
 * ------------------------------------------------------------
 * Program: ComposerApp (Assignment 6.2)
 * File: MemComposerDao.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-10-17
 * Description:
 *   In-memory implementation of ComposerDao seeded with five composers.
 * ------------------------------------------------------------
 */

public class MemComposerDao implements ComposerDao {

    private final List<Composer> composers;

    public MemComposerDao() {
        composers = new ArrayList<>();
        composers.add(new Composer(1001, "Ludwig van Beethoven", "Classical"));
        composers.add(new Composer(1002, "Johann Sebastian Bach", "Baroque"));
        composers.add(new Composer(1003, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1004, "Frédéric Chopin", "Romantic"));
        composers.add(new Composer(1005, "Duke Ellington", "Jazz"));
    }

    @Override
    public List<Composer> findAll() {
        return Collections.unmodifiableList(composers);
    }

    @Override
    public Composer findBy(Integer id) {
        if (id == null) return null;
        for (Composer c : composers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void insert(Composer entity) {
        if (entity != null) {
            composers.add(entity);
        }
    }
}
