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

    /**
     * Retrieves a list of ToDoDTO objects
     * This method calls the mapper to fetch data from the database.
     * @param locale used to pass the switched language value.
     * @return A list of ToDoDTO containing the Request and answer information.
     */
    @Override
    public List<ToDoDTO> getToDoByLocale(String locale) {
        List<ToDoDTO> toDos = toDoMapper.findToDoByLocale(locale);
        return toDoMapper.findToDoByLocale(locale);
    }

}
