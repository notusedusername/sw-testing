package hu.tigra.pti.geb.page

import geb.Page
import geb.module.Checkbox
import geb.module.RadioButtons
import geb.module.Select
import geb.module.Textarea
import hu.tigra.pti.geb.module.Date
import hu.tigra.pti.geb.module.ErrorMessages

class RegisterPage extends Page {

    static url = 'index.php?controller=authentication&back=my-account#account-creation'

    static at = { header.text() == 'CREATE AN ACCOUNT' }

    static content = {
        errorMessages(required: false) { $('div[class="alert alert-danger"]:first-of-type').module ErrorMessages }
        header { $('h1[class="page-heading"]') }
        gender { $('input[type="radio"][name="id_gender"]').module(RadioButtons) }
        firstName { $('input[id="customer_firstname"]') }
        lastName { $('input[id="customer_lastname"]') }
        password { $('input[id="passwd"]') }
        dateOfBirth { module(Date) }
        newsletter { $('input[id="newsletter"]').module(Checkbox) }
        offers { $('input[id="optin"]').module(Checkbox) }
        company { $('input[id="company"]') }
        address { $('input[id="address1"]') }
        city { $('input[id="city"]') }
        state { $('select[id="id_state"]') }
        postalCode { $('input[id="postcode"]') }
        other { $('textarea[id="other"]') }
        phone { $('input[id="phone"]') }
        mobilePhone { $('input[id="phone_mobile"]') }
        alias { $('input[id="alias"]') }
        registerButton { $('button[id="submitAccount"]') }
        firstNameAddress { $('input[id="firstname"]') }
        lastNameAddress { $('input[id="lastname"]') }
        company { $('input[id="company"]') }
        addressLine1 { $('input[id="address1"]') }
        addressLine2 { $('input[id="address2"]') }
        city { $('input[id="city"]') }
        state {$('#id_state').module(Select)}
        zipCode { $('input[id="postcode"]') }
        country {$('#id_country').module(Select)}
        additionalInfo { $('#other').module(Textarea) }
        homePhone { $('input[id="phone"]') }
        mobilePhone { $('input[id="phone_mobile"]') }
        addresAlias { $('input[id="alias"]') }
    }
}
