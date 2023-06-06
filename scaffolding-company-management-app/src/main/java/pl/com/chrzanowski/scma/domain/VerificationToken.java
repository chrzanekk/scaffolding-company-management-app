package pl.com.chrzanowski.scma.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private Long id;

    @Column(name = "verification_token")
    private String verificationToken;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name = "creation_date")
    private Date createDate;

    @Column(name = "valid_date")
    private Date validDate;

    public VerificationToken(Long id, String verificationToken, User user, Date createDate, Date validDate) {
        this.id = id;
        this.verificationToken = verificationToken;
        this.user = user;
        this.createDate = createDate;
        this.validDate = validDate;
    }

    public VerificationToken() {
    }

    public Long getId() {
        return id;
    }

    public VerificationToken setId(Long id) {
        this.id = id;
        return this;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public VerificationToken setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
        return this;
    }

    public User getUser() {
        return user;
    }

    public VerificationToken setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public VerificationToken setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getValidDate() {
        return validDate;
    }

    public VerificationToken setValidDate(Date validDate) {
        this.validDate = validDate;
        return this;
    }
}
