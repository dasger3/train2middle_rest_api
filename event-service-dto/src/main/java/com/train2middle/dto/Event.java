package com.train2middle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the event", name = "id")
    private Long id;

    @ApiModelProperty(notes = "Title of the event", name = "title", required = true, value = "Test title")
    private String title;

    @ApiModelProperty(notes = "Place of the event", name = "place", required = true, value = "Test place")
    private String place;

    @ApiModelProperty(notes = "Speaker of the event", name = "speaker", required = true, value = "Test speaker")
    private String speaker;

    @Enumerated(EnumType.STRING)
    @JsonProperty("event_type")
    @ApiModelProperty(notes = "Type of the event", name = "event_type", required = true, value = "BIRTHDAY")
    private EventType eventType;

    @JsonProperty("date_time")
    @ApiModelProperty(notes = "Date of the event", name = "date_time", required = true, value = "2022-02-09T22:29:51.940Z")
    private Date dateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Event event = (Event) o;
        return id != null && Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
