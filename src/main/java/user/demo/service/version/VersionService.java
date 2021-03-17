package user.demo.service.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.demo.model.Version;
import user.demo.repository.VersionRepository;

import java.util.List;

@Service
public class VersionService implements IVersionService {
    @Autowired
    private VersionRepository versionRepository;

    @Override
    public List<Version> findAll() {
        return versionRepository.findAll();
    }

    @Override
    public Version findById(Long id) {
        return versionRepository.getOne(id);
    }

    @Override
    public Version add(Version version) {
        return versionRepository.save(version);
    }

    @Override
    public Version update(Version version) {
        return versionRepository.save(version);
    }

    @Override
    public void remove(Long id) {
        versionRepository.delete(versionRepository.getOne(id));
    }
}
