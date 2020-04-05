package hu.tigra.pti.geb.module


class RandomMail {
    def static generateRandomMail(){
        def date = new java.util.Date()
        def salt = date.toString().replace(" ", "").replace(":", "")
        return "bamboozled" + salt +"@email.com"
    }
}
