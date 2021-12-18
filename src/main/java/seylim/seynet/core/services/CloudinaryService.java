package seylim.seynet.core.services;

import org.springframework.web.multipart.MultipartFile;
import seylim.seynet.core.utilities.DataResult;

import java.io.File;

public interface CloudinaryService {
    DataResult<?> upload(File file);

    DataResult<?> delete(String publicIdOfImage);
}
