package seylim.seynet.core.adaptors;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import seylim.seynet.core.services.CloudinaryService;
import seylim.seynet.core.utilities.DataResult;
import com.cloudinary.*;
import seylim.seynet.core.utilities.ErrorDataResult;
import seylim.seynet.core.utilities.SuccessDataResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class CloudinaryAdaptor implements CloudinaryService {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryAdaptor(Cloudinary cloudinary){
        this.cloudinary = cloudinary;
    }

    @Override
    public DataResult<?> upload(File file) {
        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            return new SuccessDataResult<>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<?> delete(String publicIdOfImage) {
        List<String> publicIdsOfImages = new ArrayList<String>();
        publicIdsOfImages.add(publicIdOfImage);

        try {
            Map<?, ?> deleteResult = cloudinary.api().deleteResources(publicIdsOfImages, ObjectUtils.emptyMap());
            return new SuccessDataResult<>(deleteResult);
        } catch (Throwable e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }
}
