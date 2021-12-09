package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;

import java.util.List;

public interface BaseEntityService<T> {

    Result add(T entity);

    Result update(T entity);

    Result delete(int id);

    DataResult<List<T>> getAll();

    DataResult<T> getById(int id);
}
