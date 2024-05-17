package sejong.hackerton.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sejong.hackerton.demo.entity.TodoList;
import sejong.hackerton.demo.repository.ToDoListRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {
    @Autowired
    private ToDoListRepository toDoListRepository;

    public List<TodoList> findAll(){
        return toDoListRepository.findAll();
    }

    public Optional<TodoList> findById(Long id){
        return toDoListRepository.findById(id);
    }

    public TodoList save(TodoList todoList){
        return toDoListRepository.save(todoList);
    }

    public void deleteById(Long id){
        toDoListRepository.deleteById(id);
    }
}
