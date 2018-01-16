package com.novotec.samples.greetings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Khue Cung on 1/15/18.
 */
@Entity
@Table(name = "GREETING")
public class Greeting implements Serializable {

    private static final long serialVersionUID = -8915502525252867482L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MESSAGE")
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GREETING_TIME")
    private Date greetingTime;

    public Greeting() {}

    private Greeting(Builder builder) {
        setId(builder.id);
        setMessage(builder.message);
        setGreetingTime(builder.greetingTime);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getGreetingTime() {
        return greetingTime;
    }

    public void setGreetingTime(Date greetingTime) {
        this.greetingTime = greetingTime;
    }

    public static final class Builder {
        private Long id;
        private String message;
        private Date greetingTime;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withMessage(String val) {
            message = val;
            return this;
        }

        public Builder withGreetingTime(Date val) {
            greetingTime = val;
            return this;
        }

        public Greeting build() {
            return new Greeting(this);
        }
    }
}
