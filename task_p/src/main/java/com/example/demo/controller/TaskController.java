package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TaskUpdateRequest;
import com.example.demo.dto.TaskRequest;
import com.example.demo.entity.TaskEntity;
import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskservice;

    @GetMapping("/list")
    public String list(Model model) {
        List<TaskEntity> taskList = taskservice.searchAll();
        model.addAttribute("taskList", taskList); // ★ 大文字L
        return "task/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("taskRequest", new TaskRequest());
        return "task/add";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute TaskRequest taskRequest,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            for (ObjectError e : result.getAllErrors()) errorList.add(e.getDefaultMessage());
            model.addAttribute("validationError", errorList);
            return "task/add";
        }
        taskservice.create(taskRequest);
        return "redirect:/task/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        TaskEntity task = taskservice.findById(id);
        model.addAttribute("task", task);
        return "task/view";
    }
    

    /** 見つからないIDのときは一覧に戻す */
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleNotFound(IllegalArgumentException e) {
        return "redirect:/task/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        TaskEntity task = taskservice.findById(id);

        TaskUpdateRequest form = new TaskUpdateRequest();
        form.setTaskId(task.getTaskId());
        form.setTaskName(task.getTaskName());
        form.setTaskStatus(task.getTaskStatus());
        form.setStartDate(task.getStartDate() == null ? "" : task.getStartDate().toString());
        form.setEndDate  (task.getEndDate()   == null ? "" : task.getEndDate().toString());

        model.addAttribute("taskUpdateRequest", form);
        return "task/edit";
    }
    
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute TaskUpdateRequest form,BindingResult result, Model model) {
if (result.hasErrors()) {
var errors = new ArrayList<String>();
for (ObjectError e : result.getAllErrors()) errors.add(e.getDefaultMessage());
model.addAttribute("validationError", errors);
return "task/edit";
}

taskservice.update(form); 
return String.format("redirect:/task/%d", form.getTaskId());
}
    
    @PostMapping("/{id}/delete")
    public String taskDelete(@PathVariable Integer id, Model model) {
        // ユーザー情報の削除
        taskservice.delete(id);
        return "redirect:/task/list";
    }
}

