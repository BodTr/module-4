package com.spring.books_management.config.mapper;

import com.spring.books_management.model.entity.BookEntity;
import com.spring.books_management.model.dto.PartialBookInforMainDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPartialBookInforMapper {

    private ModelMapper modelMapper;

    @Autowired
    public GetPartialBookInforMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(new PropertyMap<BookEntity, PartialBookInforMainDTO>() {
            @Override
            protected void configure() {
                map().setAuthorName(source.getAuthorEntity().getName());
            }

        });
    }


    public PartialBookInforMainDTO mapPartialBookDTO(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, PartialBookInforMainDTO.class);
    }
}
