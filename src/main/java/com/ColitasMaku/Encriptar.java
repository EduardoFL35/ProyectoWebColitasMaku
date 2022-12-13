package com.ColitasMaku;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var claveEduardo = encoder.encode("123");
        var claveAndres = encoder.encode("456");
        var claveJostin = encoder.encode("789");
        System.out.println("Eduardo (123): " +claveEduardo);
        System.out.println("Andres (456): " +claveAndres);
        System.out.println("Jostin (789): " +claveJostin);
    }
    
}
