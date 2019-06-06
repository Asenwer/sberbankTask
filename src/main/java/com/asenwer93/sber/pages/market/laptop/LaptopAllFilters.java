package com.asenwer93.sber.pages.market.laptop;

import com.asenwer93.sber.pages.market.BaseAllFilters;

public class LaptopAllFilters extends BaseAllFilters {
    @Override
    public LaptopAllFilters setPrice(int min, int max) {
        super.setPrice(min, max);
        return this;
    }

    @Override
    public LaptopAllFilters selectCompanies(String... companies) {
        super.selectCompanies(companies);
        return this;
    }

    @Override
    public LaptopSubcategoryPage apply() {
        super.apply();
        return new LaptopSubcategoryPage();
    }
}
