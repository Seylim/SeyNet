package seylim.seynet.core.config;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.*;
import seylim.seynet.core.adaptors.CloudinaryAdaptor;
import seylim.seynet.core.services.CloudinaryService;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinaryAccount() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dkuo6uhq4",
                "api_key", "737194858582369",
                "api_secret", "3wqASrdSoiIKb9btTi5g9RM_Ea0"
        ));
    }

    @Bean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryAdaptor(cloudinaryAccount());
    }
}
