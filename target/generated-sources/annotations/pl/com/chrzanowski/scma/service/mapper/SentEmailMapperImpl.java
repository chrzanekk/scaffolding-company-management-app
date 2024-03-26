package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.SentEmail;
import pl.com.chrzanowski.scma.domain.User;
import pl.com.chrzanowski.scma.service.dto.SentEmailDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:40+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class SentEmailMapperImpl implements SentEmailMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<SentEmail> toEntity(List<SentEmailDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SentEmail> list = new ArrayList<SentEmail>( dtoList.size() );
        for ( SentEmailDTO sentEmailDTO : dtoList ) {
            list.add( toEntity( sentEmailDTO ) );
        }

        return list;
    }

    @Override
    public List<SentEmailDTO> toDto(List<SentEmail> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SentEmailDTO> list = new ArrayList<SentEmailDTO>( entityList.size() );
        for ( SentEmail sentEmail : entityList ) {
            list.add( toDto( sentEmail ) );
        }

        return list;
    }

    @Override
    public Set<SentEmail> toEntity(Set<SentEmailDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<SentEmail> set = new LinkedHashSet<SentEmail>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( SentEmailDTO sentEmailDTO : dtoSet ) {
            set.add( toEntity( sentEmailDTO ) );
        }

        return set;
    }

    @Override
    public Set<SentEmailDTO> toDto(Set<SentEmail> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<SentEmailDTO> set = new LinkedHashSet<SentEmailDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( SentEmail sentEmail : entitySet ) {
            set.add( toDto( sentEmail ) );
        }

        return set;
    }

    @Override
    public SentEmailDTO toDto(SentEmail sentEmail) {
        if ( sentEmail == null ) {
            return null;
        }

        SentEmailDTO.Builder sentEmailDTO = SentEmailDTO.builder();

        sentEmailDTO.userId( sentEmailUserId( sentEmail ) );
        sentEmailDTO.userEmail( sentEmailUserEmail( sentEmail ) );
        sentEmailDTO.id( sentEmail.getId() );
        sentEmailDTO.title( sentEmail.getTitle() );
        sentEmailDTO.content( sentEmail.getContent() );
        sentEmailDTO.mailEvent( sentEmail.getMailEvent() );
        sentEmailDTO.language( sentEmail.getLanguage() );
        sentEmailDTO.createDatetime( sentEmail.getCreateDatetime() );

        return sentEmailDTO.build();
    }

    @Override
    public SentEmail toEntity(SentEmailDTO sentEmailDTO) {
        if ( sentEmailDTO == null ) {
            return null;
        }

        SentEmail sentEmail = new SentEmail();

        sentEmail.setUser( userMapper.fromId( sentEmailDTO.getUserId() ) );
        sentEmail.setId( sentEmailDTO.getId() );
        sentEmail.setTitle( sentEmailDTO.getTitle() );
        sentEmail.setContent( sentEmailDTO.getContent() );
        sentEmail.setMailEvent( sentEmailDTO.getMailEvent() );
        sentEmail.setLanguage( sentEmailDTO.getLanguage() );
        sentEmail.setCreateDatetime( sentEmailDTO.getCreateDatetime() );

        return sentEmail;
    }

    private Long sentEmailUserId(SentEmail sentEmail) {
        if ( sentEmail == null ) {
            return null;
        }
        User user = sentEmail.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String sentEmailUserEmail(SentEmail sentEmail) {
        if ( sentEmail == null ) {
            return null;
        }
        User user = sentEmail.getUser();
        if ( user == null ) {
            return null;
        }
        String email = user.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }
}
