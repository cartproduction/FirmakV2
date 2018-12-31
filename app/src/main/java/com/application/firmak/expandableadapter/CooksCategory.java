package com.application.firmak.expandableadapter;

import com.application.firmak.models.ProductItem;

import java.util.List;

public class CooksCategory implements ParentListItem {
    private String mName;
    private List<ProductItem> mCookss;

    public CooksCategory(String name, List<ProductItem> Cookss) {
        mName = name;
        mCookss = Cookss;
    }

    public String getName() {
        return mName;
    }

    @Override
    public List<?> getChildItemList() {
        return mCookss;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}