package com.we.springboot.redis.controller;

import com.we.springboot.redis.bean.Department;
import com.we.springboot.redis.bean.ResultDataObject;
import com.we.springboot.redis.service.DepartmentService;
import com.we.springboot.redis.utils.ResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("dept")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("save")
    public ResultDataObject save(@RequestBody Department department) {
        return ResultUtil.success(departmentService.save(department));
    }

    @DeleteMapping("delete/{id}")
    public ResultDataObject delete(@PathVariable Integer id) {
        departmentService.delete(id);
        return ResultUtil.success();
    }

    @GetMapping("findById/{id}")
    public ResultDataObject findById(@PathVariable Integer id) {
        return ResultUtil.success(departmentService.findById(id));
    }

    @GetMapping("findAll")
    public ResultDataObject findAll() {
        return ResultUtil.success(departmentService.findAll());
    }

    @PutMapping("update")
    public ResultDataObject update(@RequestBody Department department) {
        return ResultUtil.success(departmentService.update(department));
    }


}
