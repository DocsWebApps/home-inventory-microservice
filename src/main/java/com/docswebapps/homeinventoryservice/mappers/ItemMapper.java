package com.docswebapps.homeinventoryservice.mappers;

import com.docswebapps.homeinventoryservice.domain.Item;
import com.docswebapps.homeinventoryservice.web.model.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = DateMapper.class)
public interface ItemMapper {
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "itemModel", ignore = true)
    @Mapping(target = "itemOwner", ignore = true)
    @Mapping(target = "itemLocation", ignore = true)
    @Mapping(target = "itemCategory", ignore = true)
    Item itemDtoToItem(ItemDto itemDto);

    ItemDto itemDtoToItem(Item item);
}
