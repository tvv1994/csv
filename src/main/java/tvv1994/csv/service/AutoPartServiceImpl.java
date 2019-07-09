package tvv1994.csv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tvv1994.csv.model.AutoPart;
import tvv1994.csv.model.AutoPart1;
import tvv1994.csv.repository.AutoPartRepository;

@Service
public class AutoPartServiceImpl implements AutoPartService {

    @Autowired
    private AutoPartRepository repository;

    @Override
    @Transactional
    public void save(AutoPart1 autoPart1) {
        AutoPart autoPart = new AutoPart(autoPart1.getVendor(), autoPart1.getNumber(),
                autoPart1.getDescription(), autoPart1.getPrice(), autoPart1.getCount());
        repository.save(autoPart);
    }
}
