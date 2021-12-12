package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.Image;

import java.util.List;

public interface ImageService extends BaseEntityService<Image>{

    DataResult<List<Image>> getByUser_Id(int userId);
}
