package Module_6;
/*
 * ------------------------------------------------------------
 * Program: ComposerApp (Assignment 6.2)
 * File: GenericDao.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-10-17
 * Description:
 * Generic DAO interface declaring common persistence operations.
 * ------------------------------------------------------------
 */
import java.util.List;
public interface GenericDao<T, ID> {
    //return all entities
    List<T> findAll();

    //return a single entity matching the provided id, or null if not found
    T findBy(ID id);

    //insert the provided entity into the underlying collection/store
    void insert(T entity);
}//end class
