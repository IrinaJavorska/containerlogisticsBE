package cz.vsb.controller;

import cz.vsb.entity.ContainerEntity;
import cz.vsb.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/containers")
public class ContainerController {
    @Autowired
    private ContainerService containerService;

    @GetMapping
    public List<ContainerEntity> getAllContainers(@RequestParam(required = false) String action, @RequestParam(required = false) String ids) {
        if ("getSpec".equals(action) && ids != null) {
            List<Long> idList = List.of(ids.split(",")).stream().map(Long::parseLong).collect(Collectors.toList());
            return containerService.getContainersByIds(idList);
        }
        return containerService.getAllContainers();
    }

    @PostMapping
    public ContainerEntity createContainer(@RequestBody ContainerEntity container) {
        return containerService.createContainer(container);
    }

    @PutMapping("/{id}")
    public ContainerEntity updateContainer(@PathVariable Long id, @RequestBody ContainerEntity container) {
        container.setId(id);
        return containerService.updateContainer(container);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable Long id) {
        containerService.deleteContainer(id);
    }
}