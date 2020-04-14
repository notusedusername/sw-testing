package hu.tigra.pti.geb.page

import geb.Page

class OrderConfirmationPage extends Page {

    static at = { title == 'Order confirmation - My Store' && header.displayed }

    static content = {
        header { $('h1[class="page-heading"]') }
        message(required: false) {$("p.alert.alert-success")  }
    }
}
