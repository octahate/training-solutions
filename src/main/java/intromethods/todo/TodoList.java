package intromethods.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption){
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption){
        for (Todo currentTodo: todos){
            if (currentTodo.getCaption().equals(caption)){
                currentTodo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish){
        for (String todoToFinish: todosToFinish){
            finishTodos(todoToFinish);
        }
    }

    public int numberoOfFinishedTodos(){
        int counter = 0;
        for (Todo currentTodo : todos){
            if (currentTodo.isFinished()){
                counter ++;
            }
        }
        return counter;
    }
}
