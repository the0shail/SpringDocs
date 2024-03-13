package the.zero.shail.sender.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "documents")
@Getter
@Setter
public class DocumentModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private UserModel user;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne
    private StatusModel status;

    public DocumentModel(UserModel user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public DocumentModel() {
    }

    @Override
    public String toString() {
        return "DocumentModel{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status_id=" + status +
                '}';
    }
}
