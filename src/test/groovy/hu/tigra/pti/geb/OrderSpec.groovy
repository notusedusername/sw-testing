package hu.tigra.pti.geb

import hu.tigra.pti.geb.module.Modal
import hu.tigra.pti.geb.page.MainPage
import hu.tigra.pti.geb.page.MyAccountPage
import hu.tigra.pti.geb.page.OrderConfirmationPage
import hu.tigra.pti.geb.page.OrderPage

class OrderSpec extends BaseSpec {

    def 'Legolcsóbb termék megrendelése'() {
        given: 'Bejelentkezek az oldalra'
        login(Constant.USERS.HELYES_FELHASZNALO)
        waitFor { at MyAccountPage }

        when: 'Átnavigálok a főoldalra'
        def mainPage = to MainPage

        then: 'Megjelennek a termékek'
        mainPage.products.size() != 0

        when: 'A kurzort a legolcsóbb fölé viszem és rákattintok az "Add to cart" gombra'
        def cheapestProduct = mainPage.products.min { product -> product.price }
        interact {
            moveToElement(cheapestProduct.navigator)
        }
        cheapestProduct.addToCart.click()

        // Órai feladat
        then: 'Megjelenik a kosár popup és a "Product successfully added to your shopping cart" üzenet'
        waitFor {mainPage.modal.displayed}
        mainPage.modal.successfulMessage.text().trim() == "Product successfully added to your shopping cart"

        when: 'Rákattintok a "Proceed to checkout" gombra'
        mainPage.modal.goToCart.click()
        then: 'Megjelenik a "SHOPPING-CART SUMMARY" fejlécű oldal'
        def orderPage = waitFor { at OrderPage}
        orderPage.header.text().contains("SHOPPING-CART SUMMARY")
        // 3. Házi feladat
        when: 'Rákattintok a plusz gombra az első sorban'
        int original = orderPage.summaryFirstRow.quantity
        orderPage.summaryFirstRow.plusButton.click()
        then: 'A mennyiség 2-re változik'
        waitFor {original != orderPage.summaryFirstRow.quantity}
        orderPage.summaryFirstRow.quantity == original+1
        when: 'Rákattintok a "Proceed to checkout" gombra'
        orderPage.proceedToCheckout.click()
        then: 'Megjelenik az "ADDRESSES" fejlécű oldal'
        def orderPageAddress = waitFor {at OrderPage}
        orderPageAddress.header.text() == "ADDRESSES"
        when: 'Rákattintok a "Proceed to checkout" gombra'
        orderPageAddress.proceedToCheckout.click()
        then: 'Megjelenik a "SHIPPING" fejlécű oldal'
        def orderPageShipping = waitFor {at OrderPage}
        orderPageShipping.header.text() == "SHIPPING"
        when: 'Bepipálom a checkboxot és rákattintok a "Proceed to checkout" gombra'
        orderPageShipping.shippingAgreeTerms.check()
        orderPageShipping.proceedToCheckout.click()
        then: 'Megjelenik a "PLEASE CHOOSE YOUR PAYMENT METHOD" fejlécű oldal'
        def orderPagePayment = waitFor {at OrderPage}
        orderPagePayment.header.text() == "PLEASE CHOOSE YOUR PAYMENT METHOD"
        when: 'Kiválasztom a csekk fizetési módot'
        orderPagePayment.paymentCheckButton.click()
        then: 'Megjelenik az "ORDER SUMMARY" fejlécű oldal'
        def orderPageSummary = waitFor {at MainPage}
        orderPageSummary.header.text() == "ORDER SUMMARY"
        when: 'Rákattintok az "I confirm my order" gombra'
        orderPageSummary.confirmShipping.click()
        then: 'Megjelenik a sikeres rendelés üzenete: "Your order on My Store is complete."'
        def orderPageSuccess = waitFor {at OrderConfirmationPage}
        orderPageSuccess.message.text() == "Your order on My Store is complete."
    }
}
