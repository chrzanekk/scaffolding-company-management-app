package pl.com.chrzanowski.scma.service.dto;

import java.sql.Date;
import java.util.Objects;

public class VerificationTokenDTO {

    private final Long id;
    private final String verificationToken;
    private final Long userId;
    private final String userName;
    private final String email;
    private final Date createDate;


    public VerificationTokenDTO(Long id,
                                String verificationToken,
                                Long userId,
                                String userName,
                                String email,
                                Date createDate) {
        this.id = id;
        this.verificationToken = verificationToken;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.createDate = createDate;
    }

    private VerificationTokenDTO(Builder builder) {
        id = builder.id;
        verificationToken = builder.verificationToken;
        userId = builder.userId;
        userName = builder.userName;
        email = builder.email;
        createDate = builder.createDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(VerificationTokenDTO copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.verificationToken = copy.getVerificationToken();
        builder.userId = copy.getUserId();
        builder.userName = copy.getUserName();
        builder.email = copy.getEmail();
        builder.createDate = copy.getCreateDate();
        return builder;
    }

    public Long getId() {
        return id;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerificationTokenDTO that = (VerificationTokenDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(verificationToken, that.verificationToken) && Objects.equals(userId, that.userId) && Objects.equals(userName, that.userName) && Objects.equals(email, that.email) && Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, verificationToken, userId, userName, email, createDate);
    }

    @Override
    public String toString() {
        return "VerificationTokenDTO{" +
                "id=" + id +
                ", verificationToken='" + verificationToken + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String verificationToken;
        private Long userId;
        private String userName;
        private String email;
        private Date createDate;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder verificationToken(String verificationToken) {
            this.verificationToken = verificationToken;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder createDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }

        public VerificationTokenDTO build() {
            return new VerificationTokenDTO(this);
        }
    }
}
