package com.toray.ojt.web.mapper;

import com.toray.ojt.web.dto.ToDoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ToDoMapper {
    List<ToDoDTO> findToDo();
}
