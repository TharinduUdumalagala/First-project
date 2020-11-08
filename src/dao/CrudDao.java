package dao;

import entity.SuperEntity;

import java.util.List;

public interface CrudDao <S extends SuperEntity, Id>extends SuperDao{
    public boolean save(S s) throws Exception;
    public boolean update(S s) throws Exception;
    public boolean delete(Id id) throws Exception;
    public S get(Id id) throws Exception;
    public List<S> getAll() throws Exception;
}
