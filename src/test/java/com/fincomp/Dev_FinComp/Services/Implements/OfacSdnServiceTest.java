package com.fincomp.Dev_FinComp.Services.Implements;

import com.fincomp.Dev_FinComp.DevFinCompApplication;
import com.fincomp.Dev_FinComp.Entities.Consult;
import com.fincomp.Dev_FinComp.Entities.Result;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class OfacSdnServiceTest {

    @Test
    void searchInformation() {
        OfacSdnService service = new OfacSdnService();
        Consult consult = new Consult(null, LocalDateTime.now(), "HAVIN BANK LIMITED", null, "0000", null, null);
        /*Result response = service.searchInformation(consult);

        assertEquals("CUBA", response.getPrograms());*/

    }
}