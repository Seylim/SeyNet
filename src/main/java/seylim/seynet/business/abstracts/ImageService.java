package seylim.seynet.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import seylim.seynet.core.utilities.DataResult;
import seylim.seynet.core.utilities.Result;
import seylim.seynet.entities.concretes.Image;

import java.io.File;
import java.util.List;

public interface ImageService extends BaseEntityService<Image>{
    Result upload(int userId, File file);

    DataResult<List<Image>> getByUser_Id(int userId);
}
