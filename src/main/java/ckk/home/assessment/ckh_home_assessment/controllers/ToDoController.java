package ckk.home.assessment.ckh_home_assessment.controllers;

import ckk.home.assessment.ckh_home_assessment.models.ToDoItem;
import ckk.home.assessment.ckh_home_assessment.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ToDoItem>> getToDoItemsByUserId(@PathVariable String userId) {
        List<ToDoItem> toDoItems = toDoService.getToDoItemsByUserId(userId);
        return new ResponseEntity<>(toDoItems, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ToDoItem>> getAllToDoItem() {
        List<ToDoItem> toDoItems = toDoService.getAllToDoItems();//getToDoItemsByUserId(userId);
        return new ResponseEntity<>(toDoItems, HttpStatus.OK);
    }

    @PutMapping("/{toDoItemId}")
    public ResponseEntity<ToDoItem> updateToDoItem(
            @PathVariable
            Long toDoItemId,
            @RequestParam
            Boolean isCompleted) {
        ToDoItem createdToDoItem = toDoService.updateToDoItem(toDoItemId, isCompleted);
        return new ResponseEntity<>(createdToDoItem, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ToDoItem> createToDoItem(
            @Validated
            @RequestBody
            ToDoItem toDoItem) {
        ToDoItem createdToDoItem = toDoService.createToDoItem(toDoItem);
        return new ResponseEntity<>(createdToDoItem, HttpStatus.CREATED);
    }

}