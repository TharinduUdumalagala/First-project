package bo.custom;

import dto.SubjectDTO;

import java.util.ArrayList;

public interface SubjectBo {
    public boolean Save(SubjectDTO dto) throws Exception;
    public boolean Update(SubjectDTO dto)throws Exception;
    public boolean delete(String subId) throws Exception;
    public SubjectDTO getSubject(String subId)throws Exception;
    public ArrayList<SubjectDTO>getAll()throws Exception;
    public  int getCount() throws Exception;
    public int getId(String subName) throws Exception;
    public int getNextId() throws Exception;

}
