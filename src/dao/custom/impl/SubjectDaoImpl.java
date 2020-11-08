package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.SubjectDao;
import entity.Subject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {

    @Override
    public boolean save(Subject subject) throws Exception {
        Object execute = CrudUtil.execute("INSERT INTO subject VALUES(?,?,?)",
                subject.getSubId(),
                subject.getSubName(),
                subject.getSubDiscription());
        return (boolean) execute;
    }

    @Override
    public boolean update(Subject subject) throws Exception {
        Object execute = CrudUtil.execute("UPDATE subject SET Sub_Name=?,Sub_Description=? WHERE Sub_Id=?",
                subject.getSubName(),
                subject.getSubDiscription(),
                subject.getSubId());
        return (boolean) execute;
    }

    @Override
    public boolean delete(String Sub_Id) throws Exception {
        Object execute = CrudUtil.execute("DELETE FROM Subject WHERE Sub_Id=?", Sub_Id);
        return (boolean) execute;
    }

    @Override
    public Subject get(String subId) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM subject WHERE Sub_Id= ?", subId);
        if (resultSet.next()) {
            Subject subject = new Subject(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
            return subject;
        }
        return null;
    }

    @Override
    public List<Subject> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM subject");
        ArrayList<Subject> subjectList = new ArrayList<>();
        while (resultSet.next()) {
            subjectList.add(
                    new Subject(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3))
            );
        }
        return subjectList;
    }

    @Override
    public int getCount() throws Exception {
        int count = 0;
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(Sub_Id) from Subject");
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return count;
    }

    @Override
    public int getId(String subName) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT Sub_Id FROM subject WHERE sub_Name=?",subName);
        int subId = 0;
        if (resultSet.next()){
            subId = resultSet.getInt(1);
        }
        return subId;
    }

    @Override
    public int getNextId() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT Sub_Id FROM subject ORDER BY Sub_Id DESC LIMIT 1");
        int id = 1;
        if (set.next()) {
            id = set.getInt(1);
            id++;
            return id;
        }
        return id;
    }

}
