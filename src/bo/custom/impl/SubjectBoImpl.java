package bo.custom.impl;

import bo.custom.SubjectBo;
import dao.DaoFactory;
import dao.custom.SubjectDao;
import dto.SubjectDTO;
import entity.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectBoImpl implements SubjectBo {

    private SubjectDao subjectDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.SUBJECT);

    @Override
    public boolean Save(SubjectDTO subjectDTO) throws Exception {
        return subjectDao.save(new Subject(subjectDTO.getSubId(),
                subjectDTO.getSubName(),
                subjectDTO.getSubDiscription()));
    }

    @Override
    public boolean Update(SubjectDTO subjectDTO) throws Exception {
        boolean update = subjectDao.update(new Subject(subjectDTO.getSubId(),
                subjectDTO.getSubName(),
                subjectDTO.getSubDiscription()));
        return update;
    }

    @Override
    public boolean delete(String Sub_Id) throws Exception {
        return subjectDao.delete(Sub_Id);
    }

    @Override
    public SubjectDTO getSubject(String Sub_Id) throws Exception {
        Subject s = subjectDao.get(Sub_Id);
        return new SubjectDTO(s.getSubId(),
                s.getSubName(),
                s.getSubDiscription());
    }

    @Override
    public ArrayList<SubjectDTO> getAll() throws Exception {
        List<Subject> sList = subjectDao.getAll();
        ArrayList<SubjectDTO> dtoList = new ArrayList();
        for (Subject s : sList){
            dtoList.add(new SubjectDTO(s.getSubId(),
                    s.getSubName(),
                    s.getSubDiscription()));
        }

        return dtoList;
    }

    @Override
    public int getCount() throws Exception {
        return subjectDao.getCount();
    }

    @Override
    public int getId(String subName) throws Exception {
        return subjectDao.getId(subName);
    }

    @Override
    public int getNextId() throws Exception {
        return subjectDao.getNextId();
    }
}

