package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.GradeDao;
import entity.Grade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements GradeDao {

    @Override
    public List<Grade> getAll() throws Exception {
        ResultSet resultSet =CrudUtil.execute("SELECT * FROM Grade");
        ArrayList<Grade> GradeList = new ArrayList<>();
        while (resultSet.next()){
            GradeList.add(
                    new Grade(
                            resultSet.getInt(1),
                            resultSet.getString(2)));
        }
        return GradeList;
    }

    @Override
    public int getId(String gradeName) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT Grade_Id FROM grade WHERE Grade_Name=?",gradeName);
        int gradeId= 0;
        if (resultSet.next()){
            gradeId = resultSet.getInt(1);
        }
        return gradeId;
    }

    @Override
    public int getNextId() throws Exception {
            ResultSet set = CrudUtil.execute("SELECT Grade_Id FROM grade ORDER BY Grade_Id DESC LIMIT 1");
            int id = 1;
            if (set.next()) {
                id = set.getInt(1);
                id++;
                return id;
            }
            return id;
    }
}
