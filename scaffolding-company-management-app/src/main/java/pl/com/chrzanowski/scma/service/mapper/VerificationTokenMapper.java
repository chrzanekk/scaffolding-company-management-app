package pl.com.chrzanowski.scma.service.mapper;

import org.mapstruct.Mapper;
import pl.com.chrzanowski.scma.domain.VerificationToken;
import pl.com.chrzanowski.scma.service.dto.VerificationTokenDTO;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface VerificationTokenMapper extends EntityMapper<VerificationTokenDTO, VerificationToken> {

    default VerificationToken fromId(Long id) {
        if (id == null) {
            return null;
        }
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setId(id);
        return verificationToken;
    }
}
