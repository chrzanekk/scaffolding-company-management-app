package pl.com.chrzanowski.scma.domain;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import pl.com.chrzanowski.scma.model.User;

public class LocalUser extends User implements OAuth2User, OidcUser {



}
