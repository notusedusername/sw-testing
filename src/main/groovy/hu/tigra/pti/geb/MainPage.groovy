package hu.tigra.pti.geb

import geb.Page

class MainPage extends Page {

    static url = "/index.php"

    static at = { title == 'My Store' }

    static content = {
        loginButton { $('a[class="login"]')}
    }
}
