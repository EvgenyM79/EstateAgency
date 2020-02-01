/**
 * Методы для работы с данными в БД
 */

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

public class ObjectDAO implements IObjectDAO {

    @Override
    public void save(Object obj) throws SQLException {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(obj);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }
    }

    //то же самое, что update, только работает с несколькими открытими сессиями
    @Override
    public void merge(Object obj) throws SQLException {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.merge(obj);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public void delete(Object obj) throws SQLException {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(obj);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }
    }

    //Забор всей информации из конкретной таблицы через select
    @Override
    public List getObjFromTable(String nameObj) throws SQLException {
        String query = "FROM " + nameObj;
        List listObjs = new ArrayList<Object>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            listObjs = session.createQuery(query).list();
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка чтения данных:" + nameObj, JOptionPane.OK_OPTION);
        }
        return listObjs;
    }

    //Забор всей информации из таблицы учебные заведения с условием, только по определенному району
    // используется селект
    @Override
    public List<EducateBuilding> getObjFromTable(String nameObj, String val) throws SQLException {
        //String query = "FROM " + nameObj + " WHERE "+ nameObj + ".as_area = " + val;
        String query = "FROM " + nameObj + " WHERE as_area = \'" + val + "\'";
        List<EducateBuilding> listObjs = new ArrayList<EducateBuilding>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            listObjs = session.createQuery(query).list();
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка чтения данных:" + nameObj, JOptionPane.OK_OPTION);
        }
        return listObjs;
    }

    //далее идут методы забора информации из конкретной таблица по номеру id
    @Override
    public Parents findByIdParent(int id) {
        Parents p = new Parents();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            p = HibernateUtils.getSessionFactory().openSession().get(Parents.class, id);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при чтении", JOptionPane.OK_OPTION);
        }
        return p;
    }

    @Override
    public Children findByIdChild(int id) {
        Children ch = new Children();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            ch = HibernateUtils.getSessionFactory().openSession().get(Children.class, id);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при чтении\"", JOptionPane.OK_OPTION);
        }
        return ch;
    }

    @Override
    public EducateBuilding findByIdEducation(int id) {
        EducateBuilding eb = new EducateBuilding();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            eb = HibernateUtils.getSessionFactory().openSession().get(EducateBuilding.class, id);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при чтении", JOptionPane.OK_OPTION);
        }
        return eb;
    }
}