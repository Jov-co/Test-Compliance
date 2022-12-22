package com.fincomp.Dev_FinComp.Services;

import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.File;

public interface SearchXML {

    Document readFile();

    Node existsId(String id);

    Node existsName(String name);
}
