/*
 * Harmonica Demo Application
 * Copyright (C) 2019  Kenji Otsuka
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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