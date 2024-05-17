package sejong.hackerton.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sejong.hackerton.demo.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
