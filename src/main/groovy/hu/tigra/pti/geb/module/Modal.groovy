package hu.tigra.pti.geb.module

import geb.Module

class Modal extends Module {

    static content = {
        successfulMessage(required:false) {$(".layer_cart_product h2")}
        goToCart(required:false) {$(".button-container .btn.btn-default.button.button-medium")}
    }

}
