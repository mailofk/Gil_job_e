package sejong.hackerton.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sejong.hackerton.demo.entity.TodoList;

public interface ToDoListRepository extends JpaRepository<TodoList, Long> {
}
