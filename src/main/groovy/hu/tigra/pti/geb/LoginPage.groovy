package hu.tigra.pti.geb

import geb.Page

class LoginPage extends Page {

    static url = 'index.php?controller=authentication'

    static at = { loginForm.displayed }

    static content = {
        loginForm { $('form[id="login_form"]') }
        emailAddress { $('form[id="login_form"] input[id="email"]') }
        password { $('form[id="login_form"] input[id="passwd"]') }
        loginButton { $('form[id="login_form"] button[id="SubmitLogin"]') }
    }
}
