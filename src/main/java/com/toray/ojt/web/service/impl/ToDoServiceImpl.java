package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.dto.TGuideDTO;
import com.toray.ojt.web.dto.ToDoDTO;
import com.toray.ojt.web.mapper.ToDoMapper;
import com.toray.ojt.web.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoMapper toDoMapper;

    public ToDoServiceImpl(ToDoMapper toDoMapper) {
        this.toDoMapper = toDoMapper;
        System.out.println("ToDoMapper injected: " + (this.toDoMapper != null));
    }

    @Override
    public List<ToDoDTO> getToDo() {
        List<ToDoDTO> toDos = toDoMapper.findToDo();
        System.out.println("ToDos fetched: " + toDos.size());
        for (ToDoDTO toDo : toDos) {
            System.out.println(toDo.toString());  // Print each ToDoDTO for debugging
        }
        return toDoMapper.findToDo();
    }

}
