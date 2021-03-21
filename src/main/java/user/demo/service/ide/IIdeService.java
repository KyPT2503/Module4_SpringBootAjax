package user.demo.service.ide;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import user.demo.model.Ide;
import user.demo.service.IGeneralService;

import java.util.List;

public interface IIdeService extends IGeneralService<Ide> {
    List<Ide> findAllForPageable(Pageable pageable);
}
