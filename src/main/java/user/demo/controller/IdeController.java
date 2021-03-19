package user.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import user.demo.model.Ide;
import user.demo.model.Version;
import user.demo.service.ide.IIdeService;
import user.demo.service.version.IVersionService;

import java.util.List;

@RestController
@RequestMapping("/ide")
public class IdeController {
    @Autowired
    private IIdeService ideService;
    @Autowired
    private IVersionService versionService;

    @ModelAttribute("versions")
    public List<Version> getAllVersion() {
        return versionService.findAll();
    }

    @GetMapping("")
    public ModelAndView showIndexPage() {
        return new ModelAndView("ide/index", "ides", ideService.findAll());
    }

    @PostMapping("/create")
    public List<Ide> create(@RequestBody Ide ide) {
        ideService.add(ide);
        return ideService.findAll();
    }

    @GetMapping("/all")
    public List<Ide> getAllFollowPageable(@PageableDefault(size = 3) Pageable pageable) {
        return (List<Ide>) ideService.findAllForPageable(pageable);
    }
}
