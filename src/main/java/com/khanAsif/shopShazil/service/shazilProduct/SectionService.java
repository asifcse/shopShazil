package com.khanAsif.shopShazil.service.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Section;
import java.util.List;

public interface SectionService {
        List<Section> getAllSection();
        void save(Section section);
        Section getById(Long id);
        void deleteViaId(long id);
}
