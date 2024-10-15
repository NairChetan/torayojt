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
    }

    @Override
    public List<ToDoDTO> getToDoByLocale(String locale) {
        List<ToDoDTO> toDos = toDoMapper.findToDoByLocale(locale);
        return toDoMapper.findToDoByLocale(locale);
    }

}
