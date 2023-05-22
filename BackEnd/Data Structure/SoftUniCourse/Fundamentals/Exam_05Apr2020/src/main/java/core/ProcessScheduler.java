package core;

import model.Task;
import shared.Scheduler;

import java.util.*;

public class ProcessScheduler implements Scheduler {
    List<Task> list = new ArrayList<>();
    Map<Integer, Task> map = new HashMap<>();

    @Override
    public void add(Task task) {
        if (map.containsKey(task.getId())) {
            return;
        }
        map.put(task.getId(), task);
        list.add(task);
    }

    @Override
    public Task process() {
        if (size() == 0) {
            return null;
        }
        Task task = list.get(0);
        map.remove(task.getId());
        list.remove(0);
        return task;
    }

    @Override
    public Task peek() {
        if (size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Boolean contains(Task task) {
        return map.containsKey(task.getId());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Boolean remove(Task task) {
        boolean isRemoved = list.remove(task);
        map.remove(task.getId());
        if (isRemoved) {
            return isRemoved;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Boolean remove(int id) {
        Task taskToRemove = map.get(id);

        if (taskToRemove != null) {
            map.remove(id);
            list.remove(taskToRemove);
            return true;
        }

        throw new IllegalArgumentException();
    }


    @Override
    public void insertBefore(int id, Task task) {
        int currentIndex = -1;
        int indexOf = -1;

        for (Task task1 : list) {
            indexOf++;
            if (task1.getId() == id) {
                currentIndex = indexOf;
                break;
            }
        }
        if (currentIndex != -1) {
            list.add(currentIndex, task);
            map.putIfAbsent(task.getId() , task);
            return;
        }
        throw new IllegalArgumentException();

    }

    @Override
    public void insertAfter(int id, Task task) {
        int currentIndex = -1;
        int indexOf = -1;

        for (Task task1 : list) {
            indexOf++;
            if (task1.getId() == id) {
                currentIndex = indexOf;
                break;
            }
        }

        if (currentIndex != -1) {
            list.add(currentIndex + 1, task);
            map.putIfAbsent(task.getId() , task);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void clear() {
        list.clear();
        map.clear();
    }

    @Override
    public Task[] toArray() {
        return list.toArray(Task[]::new);
    }

    @Override
    public void reschedule(Task first, Task second) {
        int firstIndex = list.indexOf(first);
        int secondIndex = list.indexOf(second);
        if (firstIndex != -1 && secondIndex != -1) {
            Collections.swap(list, firstIndex, secondIndex);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<Task> toList() {
        return list;
    }

    @Override
    public void reverse() {
        Collections.reverse(list);
    }

    @Override
    public Task find(int id) {
        Task taskToReturn = map.get(id);

        if (taskToReturn != null) {
            return taskToReturn;
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Task find(Task task) {
        Task taskToReturn = map.get(task.getId());
        if (taskToReturn != null) {
            return taskToReturn;
        }
        throw new IllegalArgumentException();
    }
}
