package hu.tigra.pti.geb.page

import geb.Page
import geb.module.Checkbox
import geb.module.RadioButtons
import geb.module.Select

class RegisterPage extends Page {

    static url = 'index.php?controller=authentication&back=my-account#account-creation'

    static at = { header.text() == 'CREATE AN ACCOUNT' }

    static content = {
        header { $('h1[class="page-heading"]') }
        gender { $('input[type="radio"][name="id_gender"]').module(RadioButtons) }
        firstName { $('input[id="customer_firstname"]') }
        lastName { $('input[id="customer_lastname"]') }
        password { $('input[id="passwd"]') }
        birthDay { $('select[id="days"][name="days"').module(Select) }
        birthMonth { $('select[id="months"][name="months"]').module(Select) }
        birthYear { $('select[id="years"][name="years"]').module(Select) }
        newsletter {$('input[type=checkbox][name=newsletter]').module(Checkbox)}
        optin {$('input[type=checkbox][name=optin]').module(Checkbox)}
        register {$('#submitAccount')}
    }
}
