package com.fincomp.Dev_FinComp.Services.Implements;


import com.fincomp.Dev_FinComp.Entities.Consult;
import com.fincomp.Dev_FinComp.Entities.Result;
import com.fincomp.Dev_FinComp.Respositories.ResultRespository;
import com.fincomp.Dev_FinComp.Services.SearchImpl.Sdn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Optional;


@Service
public class OfacSdnService {

    private static Sdn sdn = new Sdn();

    @Autowired
    private ResultRespository resultRespository;


    public final String MORE_INFORMATION = "https://sanctionssearch.ofac.treas.gov/Details.aspx?id=";
    public final String PAGE_NAME = "OFAC (office of foreign assets control)";
    public final String FOUND = "Found";
    public final String NOT_FOUND = "Not Found";


    public ResponseEntity<Result> searchInformation(Consult consult){
        Result result = new Result();
        String id = consult.getIdentificationNumber();
        String name = consult.getName();
        Node byId = sdn.existsId(id);

        if (byId != null){
            Element element = (Element) byId;
            result.setPage(MORE_INFORMATION + element.getElementsByTagName("uid").item(0).getTextContent());
            result.setPageName(PAGE_NAME);
            result.setStatusSearch(FOUND);
            result.setIdentificationNumberSearch(consult.getIdentificationNumber());
            result.setName(element.getElementsByTagName("lastName").item(0).getTextContent());
            result.setEntityType(element.getElementsByTagName("sdnType").item(0).getTextContent());
            result.setPrograms(element.getElementsByTagName("program").item(0).getTextContent());
            Optional<Result> obj = Optional.of(resultRespository.save(result));
            return obj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

        } else {
            Node byName = sdn.existsName(name);
            if (byName != null) {
                Element element = (Element) byName;
                result.setPage(MORE_INFORMATION + element.getElementsByTagName("uid").item(0).getTextContent());
                result.setPageName(PAGE_NAME);
                result.setStatusSearch(FOUND);
                result.setName(element.getElementsByTagName("lastName").item(0).getTextContent());
                result.setEntityType(element.getElementsByTagName("sdnType").item(0).getTextContent());
                result.setPrograms(element.getElementsByTagName("program").item(0).getTextContent());
                Optional<Result> obj = Optional.of(resultRespository.save(result));
                return obj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
            }
        }

        result.setPageName(PAGE_NAME);
        result.setStatusSearch(NOT_FOUND);
        Optional<Result> obj = Optional.of(resultRespository.save(result));
        return obj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // For Testing Result Set
    /*public Result searchInformation(Consult consult){
        Result result = new Result();
        String id = consult.getIdentificationNumber();
        String name = consult.getName();
        Node byId = sdn.existsId(id);

        if (byId != null){
            Element element = (Element) byId;
            result.setPage(MORE_INFORMATION + element.getElementsByTagName("uid").item(0).getTextContent());
            result.setPageName(PAGE_NAME);
            result.setStatusSearch(FOUND);
            result.setIdentificationNumberSearch(consult.getIdentificationNumber());
            result.setName(element.getElementsByTagName("lastName").item(0).getTextContent());
            result.setEntityType(element.getElementsByTagName("sdnType").item(0).getTextContent());
            result.setPrograms(element.getElementsByTagName("program").item(0).getTextContent());

            return result;

        } else {
            Node byName = sdn.existsName(name);
            if (byName != null) {
                Element element = (Element) byName;
                result.setPage(MORE_INFORMATION + element.getElementsByTagName("uid").item(0).getTextContent());
                result.setPageName(PAGE_NAME);
                result.setStatusSearch(FOUND);
                result.setName(element.getElementsByTagName("lastName").item(0).getTextContent());
                result.setEntityType(element.getElementsByTagName("sdnType").item(0).getTextContent());
                result.setPrograms(element.getElementsByTagName("program").item(0).getTextContent());
                return result;
            }
        }

        result.setPageName(PAGE_NAME);
        result.setStatusSearch(NOT_FOUND);
        return result;
    }*/
}
