package Module_6;
/*
 * ------------------------------------------------------------
 * Program: ComposerApp (Assignment 6.2)
 * File: ComposerDao.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-10-17
 * Description:
 * DAO contract for Composer persistence operations. Extends GenericDao.
 * ------------------------------------------------------------
 */
public interface ComposerDao extends GenericDao<Composer, Integer>{
    //no addiotional methods needed, inherits findAll, findBy, and insert
}//end interface
