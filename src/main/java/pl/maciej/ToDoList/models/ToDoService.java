package pl.maciej.ToDoList.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private List<String> list = new ArrayList<>();

    public void addTask(String task){
        list.add(task);
    }

    public List<String> getAllTasks() {
        return list;
    }

    public void deleteTask(int task){
        list.remove(task);
    }
}
