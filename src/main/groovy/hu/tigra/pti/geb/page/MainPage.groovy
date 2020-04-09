package hu.tigra.pti.geb.page

import geb.Page
import hu.tigra.pti.geb.module.Modal
import hu.tigra.pti.geb.module.ProductCard

class MainPage extends Page {

    static url = "/index.php"

    static at = { title == 'My Store' }

    static content = {
        loginButton { $('a[class="login"]') }
        products { $('ul[id="homefeatured"]').find('li').collect { li -> li.module ProductCard } }
        modal(required:false) {$('#layer_cart').module(Modal)}
    }
}
