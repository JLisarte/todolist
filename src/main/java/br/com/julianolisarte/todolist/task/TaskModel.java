package br.com.julianolisarte.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
/**
 * ID
 * usuáio (ID_USUARIO)
 * Descrição
 * Título
 * Data início
 * Data de Término
 * Prioridade
 */
@Data
@Entity(name = "td_tasks")
public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")

  private UUID id;
  private String description;

  @Column(length = 50)
  private String title;
  private LocalDateTime startAt;
  private LocalDateTime endAt;
  private String priority;

  private UUID idUser;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public void setTitle(String title) throws Exception {
    if(title.length() > 50) {
      throw new Exception("O campo título deve conter no máximo 50 caracteres");
    }
    this.title = title;
  }

}
