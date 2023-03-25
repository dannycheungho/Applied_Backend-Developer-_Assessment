package ckk.home.assessment.ckh_home_assessment.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "todo_items")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @JsonProperty("userId")
    private String userId;

    @Column(nullable = false)
    @JsonProperty("description")
    private String description;

    @Column(nullable = false)
    @JsonProperty("completed")
    private Boolean completed;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "completed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime completedAt;

}