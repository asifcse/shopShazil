package com.khanAsif.shopShazil.serviceImplement.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Section;
import com.khanAsif.shopShazil.service.shazilProduct.SectionService;
import org.springframework.stereotype.Service;
import com.khanAsif.shopShazil.repository.shazilProduct.SectionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SectionServiceImplement implements SectionService {
    
    @Autowired SectionRepository sectionRepository;

    @Override
    public List<Section> getAllSection() {
        return sectionRepository.findAll();
    }

    @Override
    public void save(Section section) {
        sectionRepository.save(section);
    }

    @Override
    public Section getById(Long id) {
        
        Optional<Section> optional = sectionRepository.findById(id);
        Section section = null;
        
        if(optional.isPresent()){
            section=optional.get();
        }else{
            throw new RuntimeException("Section not found"+id);
        }
        
        return section;
    }

    @Override
    public void deleteViaId(long id) {
       
        sectionRepository.deleteById(id);
    }
    
}
