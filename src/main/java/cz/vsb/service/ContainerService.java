package cz.vsb.service;

import cz.vsb.entity.ContainerEntity;
import cz.vsb.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository containerRepository;

    public List<ContainerEntity> getAllContainers() {
        return containerRepository.findAll();
    }

    public List<ContainerEntity> getContainersByIds(List<Long> ids) {
        return containerRepository.findAllById(ids);
    }

    public ContainerEntity createContainer(ContainerEntity container) {
        return containerRepository.save(container);
    }

    public void deleteContainer(Long id) {
        containerRepository.deleteById(id);
    }

    public ContainerEntity updateContainer(ContainerEntity container) {
        return containerRepository.save(container);
    }

    public ContainerEntity getContainerById(Long id) {
        return containerRepository.findById(id).orElse(null);
    }
}