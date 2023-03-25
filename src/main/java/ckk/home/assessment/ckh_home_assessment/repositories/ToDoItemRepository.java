package ckk.home.assessment.ckh_home_assessment.repositories;

import ckk.home.assessment.ckh_home_assessment.models.ToDoItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long> {
    ToDoItem findToDoItemById(Long Id);

    List<ToDoItem> findAll();

    List<ToDoItem> findByUserId(String userId);
}