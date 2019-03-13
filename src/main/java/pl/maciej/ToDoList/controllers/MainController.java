package pl.maciej.ToDoList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciej.ToDoList.models.ToDoService;

@Controller
public class MainController {


    @Autowired
    ToDoService toDoService;


    @GetMapping("/toDo")
    public String toDo(Model model){
        model.addAttribute("getList", toDoService.getAllTasks());

        return "toDo";
    }

    @PostMapping("/toDo")
    public String addTask(@RequestParam("name") String name, Model model){

    toDoService.addTask(name);

    model.addAttribute("getList", toDoService.getAllTasks());

    return "toDo";
    }
    @GetMapping("/delete/{num}")
    public String delete(@PathVariable("num") int key, Model model){

        toDoService.deleteTask(key);
        return "redirect:/toDo";
    }



}
