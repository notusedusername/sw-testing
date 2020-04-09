package hu.tigra.pti.geb.module

import geb.Module

class ProductCard extends Module {

    static content = {
        price { navigator.find('div[class="right-block"]')
                .find('span[class="price product-price"]')
                .text().substring(1).toDouble() }

        addToCart { navigator.find('a[title="Add to cart"]') }
    }
}
