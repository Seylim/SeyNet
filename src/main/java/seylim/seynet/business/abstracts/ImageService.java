package seylim.seynet.business.abstracts;

import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.entities.concretes.Image;

import java.util.List;

public interface ImageService {

    DataResult<List<Image>> getByUser_Id(int userId);
}
