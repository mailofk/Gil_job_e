package sejong.hackerton.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sejong.hackerton.demo.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
