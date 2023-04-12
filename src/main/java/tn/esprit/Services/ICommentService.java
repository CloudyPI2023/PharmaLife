package tn.esprit.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Comment;

public interface ICommentService extends JpaRepository<Comment, Long> {
}
