package com.fincomp.Dev_FinComp.Services.SearchImpl;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class SdnTest {

    final static  Sdn test = new Sdn();
    @Test
    void existsId() {
        String id = "19820215";
        Node expected = test.existsId(id);
        Element element = (Element) expected;
        assertEquals("2676", element.getElementsByTagName("uid").item(0).getTextContent());
    }

    @Test
    void existsName() {
        String name = "INDONESIAN MUJAHIDEEN COUNCIL";
        Node expected = test.existsName(name);
        Element element = (Element) expected;
        assertEquals("22484", element.getElementsByTagName("uid").item(0).getTextContent());
        assertEquals("SDGT", element.getElementsByTagName("program").item(0).getTextContent());
    }
}