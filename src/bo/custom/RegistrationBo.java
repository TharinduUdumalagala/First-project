package bo.custom;

import dto.RegistrationDTO;
import dto.StudentDTO;

import java.util.List;

public interface RegistrationBo {
    public boolean Save(RegistrationDTO dto) throws Exception;
    public boolean Update(RegistrationDTO dto)throws Exception;
    public boolean delete(String Id) throws Exception;
    public RegistrationDTO getRegistration(String Id)throws Exception;
    public List<StudentDTO> getAll();
}
