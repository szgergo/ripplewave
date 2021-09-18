package org.ripplewave.vcs.web;

import org.ripplewave.vcs.entity.VcsEntity;
import org.ripplewave.vcs.repository.VcsRepository;
import org.ripplewave.vcs.web.api.VcsCreateDto;
import org.ripplewave.vcs.web.api.VcsUpdateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.ripplewave.common.constants.CommonConstants.VCS_REST_BASE_PATH;

@RestController
@RequestMapping(path = VCS_REST_BASE_PATH)
@Transactional
@Validated
public class VcsController {

    private final VcsRepository vcsRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(VcsController.class);

    public VcsController(VcsRepository vcsRepository) {
        this.vcsRepository = vcsRepository;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<Void> saveVcs(@RequestBody VcsCreateDto vcsCreateDto) {
        vcsRepository.save(VcsEntity.fromDto(vcsCreateDto.toDto()));
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<List<VcsCreateDto>> getAllVcs() {
        return ResponseEntity.ok(StreamSupport.stream(vcsRepository.findAll().spliterator(), false)
                .map(VcsEntity::toDto)
                .map(VcsCreateDto::fromPojo)
                .collect(Collectors.toList()));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteVcs(@PathVariable Long id) {
        vcsRepository.deleteById(id);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping
    public ResponseEntity<Void> updateVcs(@RequestBody VcsUpdateDto vcsUpdateDto) {
        Optional<VcsEntity> vcsEntity = vcsRepository.findById(vcsUpdateDto.getId());
        if (!vcsEntity.isPresent()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        updateEntity(vcsEntity.get(), vcsUpdateDto);
        return ResponseEntity
                .ok()
                .build();
    }

    private void updateEntity(VcsEntity vcsEntity, VcsUpdateDto vcsUpdateDto) {
        LOGGER.info("Update request: {}", vcsUpdateDto);
        vcsEntity.setName(vcsUpdateDto.getName());
        vcsEntity.setDescription(vcsUpdateDto.getDescription());
        vcsEntity.setAccessToken(vcsUpdateDto.getAccessToken());
    }
}
