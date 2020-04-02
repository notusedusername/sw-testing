package hu.tigra.pti.geb

import hu.tigra.pti.geb.entity.User

class Constant {

    static final USERS = [
            HELYES_FELHASZNALO: new User(emailAddress: 'golya.adam@tigra.hu', password: 'Admin'),
            HELYTELEN_FELHASZNALO: new User(emailAddress: 'golya.adam@tigra.hu', password: 'Barack')
    ]
}
