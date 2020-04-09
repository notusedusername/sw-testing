package hu.tigra.pti.geb.page

import geb.Page
import geb.module.Checkbox
import hu.tigra.pti.geb.module.ProductRow

class OrderPage extends Page {

    static url = "/index.php?controller=order"

    static at = { title == 'Order - My Store' && header.displayed }

    static content = {
        header { $('h1[class="page-heading"]') }

        nextButton(required: false) { $('p.cart_navigation').$('.button.btn.btn-default.button-medium') }

        // 3. házi feladat
        // A summaryFirstRow a táblázat első sorát választja ki
        // A táblázat "tbody"-ában az első "tr"-t kell beadni a ProductRow modulba
        summaryFirstRow(required: false) {  }

        shippingAgreeTerms(required: false) {  }

        paymentCheckButton(required: false) {  }

        message(required: false) {  }
    }
}
