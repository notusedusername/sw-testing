package hu.tigra.pti.geb

import hu.tigra.pti.geb.module.RandomMail
import hu.tigra.pti.geb.page.LoginPage
import hu.tigra.pti.geb.page.MyAccountPage
import hu.tigra.pti.geb.page.RegisterPage

class RegisterSpec extends BaseSpec {

    def 'Regisztráció hibás'() {
        given: 'Bejelentkező felületre navigálok'
        def loginPage = to LoginPage

        when: 'Kitöltöm a "CREATE AN ACCOUNT" blokkban az "Email address" mezőt egy még nem regisztrált email címmel és a "Create an account" funkciógombra kattintok.'
        loginPage.registerEmailAddress = 'tesz2t@email.hu'
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


    def 'Regisztráció'() {
        given: 'Bejelentkező felületre navigálok'
        def loginPage = to LoginPage

        when: 'Kitöltöm a "CREATE AN ACCOUNT" blokkban az "Email address" mezőt egy még nem regisztrált email címmel és a "Create an account" funkciógombra kattintok.'
        loginPage.registerEmailAddress = RandomMail.generateRandomMail()
        loginPage.registerButton.click()

        then: 'Megjelenik a "Create an account" űrlap.'
        def registerPage = waitFor { at RegisterPage }

        when: 'Kitöltöm az összes mezőt és a "Register" funkciógombra kattintok.'
        registerPage.gender.checked = 'Mr.'
        registerPage.firstName = 'Elek'
        registerPage.lastName = 'Teszt'
        registerPage.password = 'teszt123'
        registerPage.dateOfBirth.value('1990', 'May', '12')
        registerPage.newsletter.check()
        registerPage.offers.check()

        registerPage.lastNameAddress = 'Elek'
        registerPage.firstNameAddress = 'Teszt'
        registerPage.company = 'ACME'
        registerPage.addressLine1 = 'TEST DATA STREET 42'
        registerPage.addressLine2 = ''
        registerPage.city = 'CITYINARIZONA'
        registerPage.zipCode = '12345'
        registerPage.country.selected = 'United States'
        registerPage.state.selected = 'Arizona'
        registerPage.additionalInfo = 'THE DOG IS BITING'
        registerPage.homePhone = '00123245677'
        registerPage.mobilePhone = '002342356436'
        registerPage.addresAlias = 'ADDRESS '

        registerPage.registerButton.click()

        then: 'Betölt a my account page'
        def myAccountPage = waitFor { at MyAccountPage }
        myAccountPage.header.text() == "MY ACCOUNT"

    }
}
