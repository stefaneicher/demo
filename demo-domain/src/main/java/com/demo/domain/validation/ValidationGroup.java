package com.demo.domain.validation;


import jakarta.validation.groups.Default;


public interface ValidationGroup {
    interface PERSON extends Default {
    }

    interface VERSICHERUNGEN extends PERSON {
    }

    interface ADDRESSES extends VERSICHERUNGEN {
    }

    interface ANGEBOT extends ADDRESSES {
    }

    interface BESTELLUNG extends ANGEBOT {
    }
}
