package seylim.seynet.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import seylim.seynet.entities.concretes.Image;

import java.util.List;

public interface ImageDao extends JpaRepository<Image, Integer> {

    Image getByUser_Id(int userId);
}
