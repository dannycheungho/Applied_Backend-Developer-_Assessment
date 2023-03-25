package ckk.home.assessment.ckh_home_assessment.services;


import ckk.home.assessment.ckh_home_assessment.models.ToDoItem;
import ckk.home.assessment.ckh_home_assessment.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ToDoService {

    private ToDoItemRepository toDoItemRepository;

    @Autowired
    public ToDoService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public List<ToDoItem> getToDoItemsByUserId(String userId) {
        return toDoItemRepository.findByUserId(userId);
    }

    public List<ToDoItem> getAllToDoItems() {
        return toDoItemRepository.findAll();
    }

    public ToDoItem createToDoItem(ToDoItem toDoItem) {
        toDoItem.setCreatedAt(LocalDateTime.now());
        return toDoItemRepository.save(toDoItem);
    }

    public ToDoItem updateToDoItem(Long id, Boolean isCompleted) {
        ToDoItem existingToDoItem = toDoItemRepository.findToDoItemById(id);
        existingToDoItem.setCompleted(isCompleted);

        if (isCompleted) {
            existingToDoItem.setCompletedAt(LocalDateTime.now());
        }

        return toDoItemRepository.save(existingToDoItem);
    }
}
