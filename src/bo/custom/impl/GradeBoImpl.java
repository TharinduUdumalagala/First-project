package bo.custom.impl;

import bo.custom.GradeBo;
import dao.DaoFactory;
import dao.custom.GradeDao;
import dto.GradeDTO;
import entity.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradeBoImpl implements GradeBo {

    private GradeDao gradeDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.GRADE);

    @Override
    public ArrayList<GradeDTO> getAll() throws Exception {
        List<Grade> sList = gradeDao.getAll();
        ArrayList<GradeDTO> dtoList = new ArrayList();
        for (Grade s : sList){
            dtoList.add(new GradeDTO(s.getGrade_Id(),
                    s.getGrade_Name()));
        }
        return dtoList;
    }

    @Override
    public int getId(String gradeName) throws Exception {
        return gradeDao.getId(gradeName);
    }
}
