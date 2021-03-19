package user.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import user.demo.model.Version;
import user.demo.service.version.IVersionService;

@RestController
@RequestMapping("/version")
public class VersionController {
    @Autowired
    private IVersionService versionService;

    @GetMapping("")
    public ModelAndView showIndex() {
        return new ModelAndView("version/index", "versions", versionService.findAll());
    }

    @PostMapping("/create")
    public Version create(@RequestBody Version version) {
        return versionService.add(version);
    }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        versionService.remove(id);
        return "Removed version, id:" + id;
    }

    @GetMapping("/{id}")
    public Version getSingleVersion(@PathVariable("id") Version version) {
        return version;
    }

    @PutMapping("/update")
    public Version updateVersion(@RequestBody Version version) {
        versionService.update(version);
        return version;
    }
}
