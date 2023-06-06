package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.service.dto.UserDTO;
import pl.com.chrzanowski.scma.service.dto.VerificationTokenDTO;

public interface VerificationTokenService {

    VerificationTokenDTO createToken(UserDTO userDTO);

    VerificationTokenDTO getVerificationToken(String token);
}
