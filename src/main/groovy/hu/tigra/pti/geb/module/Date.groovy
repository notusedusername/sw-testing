package hu.tigra.pti.geb.module

import geb.Module

class Date extends Module {

    static content = {
        days { $('select[id="days"]') }
        months { $('select[id="months"]') }
        years { $('select[id="years"]') }
    }

    def value(years, months, days) {
        this.years = years
        this.months = "${months} "
        this.days = days
    }
}
