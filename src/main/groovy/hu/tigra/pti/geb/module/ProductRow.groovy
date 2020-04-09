package hu.tigra.pti.geb.module

import geb.Module

class ProductRow extends Module {

    static content = {
        quantity { navigator.find('td.cart_quantity').find('input.cart_quantity_input')
                .value().toString().toInteger() }

        plusButton { navigator.find('td.cart_quantity').find('a.cart_quantity_up.button-plus') }
    }
}
