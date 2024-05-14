import com.demo.domain.dao.RechnerDto;
import com.demo.domain.service.RechnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RechnerRestController {


    private final RechnerService rechnerService;

    @PostMapping
    RechnerDto post() {
        return rechnerService.create();
    }

    @PutMapping("rechner/{rechnerUuid}")
    RechnerDto put(RechnerDto dto, @PathVariable UUID rechnerUuid) {
        return rechnerService.update(dto, rechnerUuid);
    }
}
