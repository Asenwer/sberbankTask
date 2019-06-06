package com.asenwer93.sber.pages.market.tablets;

import com.asenwer93.sber.pages.market.BaseAllFilters;
import com.asenwer93.sber.pages.market.BaseSubcategoryPage;

public class TabletAllFilters extends BaseAllFilters {
    @Override
    public BaseAllFilters setPrice(int min, int max) {
        super.setPrice(min, max);
        return this;
    }

    @Override
    public BaseAllFilters selectCompanies(String... companies) {
        super.selectCompanies(companies);
        return this;
    }

    @Override
    public BaseSubcategoryPage apply() {
        super.apply();
        return new TabletSubcategoryPage();
    }
}
