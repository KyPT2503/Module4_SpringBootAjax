package user.demo.service.ide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import user.demo.model.Ide;
import user.demo.repository.IdeRepository;

import java.util.List;

@Service
public class IdeService implements IIdeService {
    @Autowired
    private IdeRepository ideRepository;

    @Override
    public List<Ide> findAll() {
        return ideRepository.findAll();
    }

    @Override
    public Ide findById(Long id) {
        return ideRepository.getOne(id);
    }

    @Override
    public Ide add(Ide ide) {
        return ideRepository.save(ide);
    }

    @Override
    public Ide update(Ide ide) {
        return ideRepository.save(ide);
    }

    @Override
    public void remove(Long id) {
        ideRepository.delete(ideRepository.getOne(id));
    }

    @Override
    public Page<Ide> findAllForPageable(Pageable pageable) {
        return ideRepository.findAll(pageable);
    }
}
