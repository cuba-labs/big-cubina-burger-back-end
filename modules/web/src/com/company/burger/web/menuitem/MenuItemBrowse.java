package com.company.burger.web.menuitem;

import com.company.burger.entity.MenuItem;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;

public class MenuItemBrowse extends AbstractLookup {
    @Inject
    private Table<MenuItem> menuItemsTable;
    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        menuItemsTable.addGeneratedColumn("image", menuItem -> {
            if (menuItem.getImage() != null) {
                Image avatarImage = componentsFactory.createComponent(Image.class);
                avatarImage.setScaleMode(Image.ScaleMode.SCALE_DOWN);
                avatarImage.setAlignment(Alignment.MIDDLE_CENTER);
                avatarImage.setWidth("100%");
                avatarImage.setHeight("30px");

                avatarImage.setDatasource(menuItemsTable.getItemDatasource(menuItem), "image");
                return avatarImage;
            }
            return null;
        });
    }
}