package hu.tigra.pti.geb

class LoginSpec extends BaseSpec {

    def 'Helyes bejelentkezés'() {
        given: 'Megérkezünk a főoldalra.'
        MainPage mainPage = waitFor { to MainPage }

        when: 'Rákattintok a Sign in gombra.'
        mainPage.loginButton.click()

        then: 'Megérkezek a bejelentkező felületre.'
        LoginPage loginPage = waitFor { at LoginPage }
        loginPage.loginForm.displayed

        when: 'Kitöltöm a mezőket helyes adatokkal és rányomok a belépés gombra.'
        loginPage.emailAddress = 'golya.adam@tigra.hu'
        loginPage.password = 'Admin'
        loginPage.loginButton.click()

        then: 'Megjelenik a felhasználó adatai felület: “My account”.'
        MyAccountPage myAccountPage = waitFor { at MyAccountPage }
        myAccountPage.header.text() == "MY ACCOUNT"
    }

    def 'Helytelen bejelentkezés'() {
        given: 'Megérkezünk a főoldalra.'
        MainPage mainPage = waitFor { to MainPage }

        when: 'Rákattintok a Sign in gombra.'
        mainPage.loginButton.click()

        then: 'Megérkezek a bejelentkező felületre.'
        LoginPage loginPage = waitFor { at LoginPage }
        loginPage.loginForm.displayed

        when: 'Kitöltöm a mezőket hibás adatokkal és rányomok a belépés gombra.'
        loginPage.emailAddress = 'golya.adam@tigra.hu'
        loginPage.password = 'Adin'
        loginPage.loginButton.click()

        then: 'Megjelenik az error.'
        LoginPage loginPage1 = waitFor { at LoginPage }
        loginPage1.loginForm.displayed
        loginPage1.$(".page-heading+div.alert.alert-danger").displayed
        loginPage1.$("div.alert.alert-danger li").text() == "Invalid password."
    }
}