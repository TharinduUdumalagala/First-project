package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ParentDao;
import entity.Parent;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParentDaoImpl implements ParentDao {
    @Override
    public boolean save(Parent parent) throws Exception {
        return CrudUtil.execute("INSERT INTO Parent VALUES(?,?,?)",
                parent.getParentId(),
                parent.getParentName(),
                parent.getPhoneNo());
    }

    @Override
    public boolean update(Parent parent) throws Exception {
        return CrudUtil.execute("UPDATE Subject SET Parent_Name=?,Phone_No=? WHERE Parent_Id=?",
                parent.getParentId(),
                parent.getParentName(),
                parent.getPhoneNo());
    }

    @Override
    public boolean delete(String Parent_Id) throws Exception {
        return CrudUtil.execute("DELETE FOM Parent WHERE Parent_Id=?",Parent_Id);
    }

    @Override
    public Parent get(String Parent_Id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Parent WHERE Parent_Id= ?",Parent_Id);
        if (resultSet.next()){
            return new Parent(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }else {
            return null;
        }
    }

    @Override
    public List<Parent> getAll() throws Exception {
        ResultSet resultSet =CrudUtil.execute("SELECT * FROM Parent");
        ArrayList<Parent> ParentList = new ArrayList<>();
        while (resultSet.next()){
            ParentList.add(
                    new Parent(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3))
            );
        }
        return ParentList;
    }

    @Override
    public int getNextId() throws Exception {
            ResultSet set = CrudUtil.execute("SELECT Parent_Id FROM parent ORDER BY Parent_Id DESC LIMIT 1");
            int id = 1;
            if (set.next()) {
                id = set.getInt(1);
                id++;
                return id;
            }
            return id;
    }
}
