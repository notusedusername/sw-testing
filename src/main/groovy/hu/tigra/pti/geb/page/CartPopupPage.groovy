package hu.tigra.pti.geb.page

import geb.Page

class CartPopupPage extends Page {

    static at = { popup.displayed }

    static content = {
        popup { $('div[id="layer_cart"]') }

        message { popup.find('div.layer_cart_product').find('h2').text() }

        checkoutButton { popup.find('a[title="Proceed to checkout"]') }
    }
}
