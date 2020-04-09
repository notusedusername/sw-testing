package hu.tigra.pti.geb

import hu.tigra.pti.geb.page.LoginPage
import hu.tigra.pti.geb.page.MyAccountPage
import hu.tigra.pti.geb.page.RegisterPage

class RegisterSpec extends BaseSpec {

    def 'Regisztráció'() {
        given: 'Bejelentkező felületre navigálok'
        def loginPage = to LoginPage

        when: 'Kitöltöm a "CREATE AN ACCOUNT" blokkban az "Email address" mezőt egy még nem regisztrált email címmel és a "Create an account" funkciógombra kattintok.'
        loginPage.registerEmailAddress = 'teszt@email.hu'
        loginPage.registerButton.click()

        then: 'Megjelenik a "Create an account" űrlap.'
        def registerPage = waitFor { at RegisterPage }

        when: 'Kitöltöm a "Your personal information" blokkban az összes mezőt és a "Register" funkciógombra kattintok.'
        registerPage.gender.checked = 'Mr.'
        registerPage.firstName = 'Elek'
        registerPage.lastName = 'Teszt'
        registerPage.password = 'teszt123'
        registerPage.dateOfBirth.value('1990', 'May', '12')
        registerPage.newsletter.check()
        registerPage.offers.check()
        registerPage.registerButton.click()

        then: '5 hibaüzenet jelenik meg'
        registerPage.errorMessages.values.size() == 5

        when: 'Kitöltöm a "Your address" blokkban az összes mezőt és "Register" funkciógombra kattintok.'
        registerPage.password = 'teszt123'
        registerPage.company = 'Az én cégem kft'
        registerPage.address = 'zöld utca 42.'
        registerPage.city = 'Pirosváros'
        registerPage.state = 'Florida'
        registerPage.postalCode = '12345'
        registerPage.other = 'Valami nagyon fontos információ...'
        registerPage.phone = '06123456789'
        registerPage.mobilePhone = '06987654321'
        registerPage.alias = 'Az én kicsi címem'
        registerPage.registerButton.click()

        then: 'Megjelenik a felhasználó adatai felület: "My account".'
        def myAccountPage = waitFor { at MyAccountPage }
        myAccountPage.header.text() == "MY ACCOUNT"
    }
}
