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
}