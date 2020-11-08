package bo.custom;

import dto.StudentDTO;

import java.util.List;

public interface StudentBo {
    public int getNextId() throws Exception;
    public int getCount() throws Exception;
    public List<StudentDTO> getAll();

}
