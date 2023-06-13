package pl.com.chrzanowski.scma.service.mapper;

import org.mapstruct.Mapper;
import pl.com.chrzanowski.scma.domain.SentEmail;
import pl.com.chrzanowski.scma.service.dto.SentEmailDTO;

@Mapper(componentModel = "spring", uses = {})
public interface SentEmailMapper extends EntityMapper<SentEmailDTO, SentEmail> {

    default SentEmail fromId(Long id) {
        if (id == null) {
            return null;
        }
        SentEmail sentEmail = new SentEmail();
        sentEmail.setId(id);
        return sentEmail;
    }
}
