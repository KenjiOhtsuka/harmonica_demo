package com.example.demo.presentation.task

import com.example.demo.domain.task.Task
import com.example.demo.domain.task.TaskRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("task")
class TaskController(
    private val taskRepository: TaskRepository
) {
    @GetMapping
    fun list(modelMap: ModelMap): String {
        modelMap["taskList"] =
            taskRepository.findAll(
                Sort.by("id").descending()
            )
        modelMap["newTask"] = Task()
        return "task/index"
    }

    @PostMapping
    fun create(
        attributes: RedirectAttributes,
        @ModelAttribute task: Task
    ): String {
        taskRepository.save(task)
        attributes.addFlashAttribute(
            "success", "The Task was successfully created."
        )
        return "redirect:/task"
    }

    @DeleteMapping("{id}")
    fun delete(
        attributes: RedirectAttributes,
        @PathVariable id: Long
    ): String {
        taskRepository.deleteById(id)
        attributes.addFlashAttribute(
            "success", "The Task was successfully deleted."
        )
        return "redirect:/task"
    }
}