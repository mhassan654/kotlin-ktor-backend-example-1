package com.saavatech.Repositories

import com.saavatech.model.Priority
import com.saavatech.model.Task

object TaskRepository {
    private val tasks = mutableListOf(
        Task("Cleaning","Clean the house", Priority.Low),
        Task("Gardening","mow the lawn", Priority.Medium),
        Task("shopping","buy the groceries", Priority.High),
        Task("painting","paint the fence", Priority.Medium)
    )

    fun allTasks(): List<Task> = tasks;

    fun tasksByPriority(priority: Priority)=tasks.filter {
        it.priority ==priority
    }

    fun taskByName(name:String) = tasks.find {
        it.name.equals(name,ignoreCase = true)
    }

    fun addTask(task: Task){
        if (taskByName(task.name) != null){
            throw IllegalStateException("cannot duplicate task name")
        }
        tasks.add(task)
    }

    fun removeTask(name: String): Boolean{
        return tasks.removeIf { it.name==name }
    }
}