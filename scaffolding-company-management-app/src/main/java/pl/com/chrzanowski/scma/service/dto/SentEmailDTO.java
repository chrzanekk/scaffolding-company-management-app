package pl.com.chrzanowski.scma.service.dto;

import pl.com.chrzanowski.scma.domain.enumeration.MailEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public class SentEmailDTO {
    private final Long id;
    private final Long userId;
    private final String userEmail;
    private final String title;
    private final String content;
    private final MailEvent event;
    private final LocalDateTime createDatetime;

    public SentEmailDTO(Long id,
                        Long userId,
                        String userEmail, String title,
                        String content,
                        MailEvent event,
                        LocalDateTime createDatetime) {
        this.id = id;
        this.userId = userId;
        this.userEmail = userEmail;
        this.title = title;
        this.content = content;
        this.event = event;
        this.createDatetime = createDatetime;
    }

    private SentEmailDTO(Builder builder) {
        id = builder.id;
        userId = builder.userId;
        userEmail = builder.userEmail;
        title = builder.title;
        content = builder.content;
        event = builder.event;
        createDatetime = builder.createDatetime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SentEmailDTO copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.userId = copy.getUserId();
        builder.userEmail = copy.getUserEmail();
        builder.title = copy.getTitle();
        builder.content = copy.getContent();
        builder.event = copy.getEvent();
        builder.createDatetime = copy.getCreateDatetime();
        return builder;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public MailEvent getEvent() {
        return event;
    }

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SentEmailDTO that = (SentEmailDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(userEmail, that.userEmail) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && event == that.event && Objects.equals(createDatetime, that.createDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, userEmail, title, content, event, createDatetime);
    }

    @Override
    public String toString() {
        return "SentEmailDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", event=" + event +
                ", createDatetime=" + createDatetime +
                '}';
    }


    public static final class Builder {
        private Long id;
        private Long userId;
        private String userEmail;
        private String title;
        private String content;
        private MailEvent event;
        private LocalDateTime createDatetime;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder event(MailEvent event) {
            this.event = event;
            return this;
        }

        public Builder createDatetime(LocalDateTime createDatetime) {
            this.createDatetime = createDatetime;
            return this;
        }

        public SentEmailDTO build() {
            return new SentEmailDTO(this);
        }
    }
}
