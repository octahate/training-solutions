package exam03retake02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {
    private List<Todo> todoList = new ArrayList<>();

    public void addTodo(Todo currentTodo){
        todoList.add(currentTodo);
    }

    public List<Todo> getTodos() {
        return todoList;
    }

    public int getNumberOfItemsLeft(){
        int counter = 0;
        for (Todo currentTodo : todoList){
            if (currentTodo.getState().equals(State.NON_COMPLETED)){
                counter++;
            }
        }
        return counter;
    }

    public List<String> getMostImportantTodosText(){
        List<String> solution = new ArrayList<>();
        List<Todo> arrangedList = new ArrayList<>(List.copyOf(todoList));
        Collections.sort(arrangedList);
        if (!arrangedList.isEmpty()) {
            int priority = arrangedList.get(0).getPriority();
            for (Todo arrangedTodo: arrangedList){
                if (arrangedTodo.getPriority() == priority){
                    solution.add(arrangedTodo.getText());
                }
            }
        }
        return solution;
    }

    public void deleteCompleted(){
        todoList.removeIf(currentTodo -> currentTodo.getState().equals(State.COMPLETED));
    }
}
