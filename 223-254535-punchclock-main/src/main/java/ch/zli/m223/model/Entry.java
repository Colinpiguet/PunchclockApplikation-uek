package ch.zli.m223.model;

import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime checkIn;

  @Column(nullable = false)
  private LocalDateTime checkOut;

  @ManyToOne
  private category category;

  @ManyToMany
  @JoinTable(
    name = "entry_tag",
    joinColumns = @JoinColumn(name = "entry_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private List<tag> tags;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(LocalDateTime checkIn) {
    this.checkIn = checkIn;
  }

  public LocalDateTime getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(LocalDateTime checkOut) {
    this.checkOut = checkOut;
  }

  public category getCategory() {
    return category;
  }

  public void setCategory(category category) {
    this.category = category;
  }

  public List<tag> getTags() {
    return tags;
  }

  public void setTags(List<tag> tags) {
    this.tags = tags;
  }
}
