package bo.custom;

import dto.GradeDTO;

import java.util.ArrayList;

public interface GradeBo {
    public ArrayList<GradeDTO> getAll()throws Exception;
    public  int getId(String gradeName)throws Exception;
}
