package com.demo.domain.service;


import com.demo.domain.dao.RechnerDto;
import com.demo.domain.dao.RechnerRepository;
import com.demo.domain.model.BeratungsId;
import com.demo.domain.model.Rechner;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Transactional
public class RechnerService {

    private final RechnerMappper rechnerMappper;
    private final RechnerRepository rechnerRepository;
    private final OrmBeratungService ormBeratungService;
    private final AngebotAntragerstellungService angebotAntragerstellungService;


    public Rechner findIdByUuid(UUID uuid) {
        return rechnerRepository.findByUuid(uuid);
    }

    public RechnerDto create() {
        BeratungsId beratungsId = ormBeratungService.erstelle();
        Rechner newRechner = createNew();
        newRechner.setBeratungsId(beratungsId.getValue());
        Rechner savedEntity = rechnerRepository.save(newRechner);
        return toDto(savedEntity);
    }

    private Rechner createNew() {
        Rechner rechner = new Rechner();
        //todo set values
        return rechner;
    }

    private RechnerDto toDto(Rechner entity) {
        return null;
    }

    public RechnerDto update(RechnerDto dto, UUID rechnerUuid) {

        return null;
    }
}
