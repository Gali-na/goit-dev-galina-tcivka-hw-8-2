package service;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TimeServiceTest {

    @Test
    void getTimeDateTimeZoneByZoneId_SetNullArgument_GetErrorMessage() {
        assertEquals("time zone does not exist", TimeService.getTimeDateTimeZoneByZoneId(null));
    }

    @Test
    void getTimeDateTimeZoneByZoneId_DefunctTimeZone_GetErrorMessage() {
        assertEquals("time zone does not exist", TimeService.getTimeDateTimeZoneByZoneId(null));
    }

    @Test
    void getTimeDateTimeZoneByZoneId_ExistTimeZone_GetInform() {
        ZoneId zone = ZoneId.of("Europe/Luxembourg");
        ZonedDateTime time = ZonedDateTime.now(zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss  'UTC'xxx");
        String expectedformattedDateTimeByZoneId = time.format(formatter);
        assertEquals(expectedformattedDateTimeByZoneId, TimeService.getTimeDateTimeZoneByZoneId("Europe/Luxembourg"));
    }
    @Test
    void getTimeDateByUTC_PositiveResult() {
        ZoneId zone = ZoneId.of("GMT0");
        ZonedDateTime time = ZonedDateTime.now(zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss  'UTC'xxx");
        String expectedformattedDateTimeByUTC = time.format(formatter);
        assertEquals(expectedformattedDateTimeByUTC, TimeService.getTimeDateByUTC());
    }

    @Test
    void checkTimeZoneValidity_SetNullArgument_GetFlse() {
        assertEquals(false, TimeService.checkTimeZoneValidity(null));
    }

    @Test
    void checkTimeZoneValidity_DefunctTimeZone_GetFlse() {
        assertEquals(false, TimeService.checkTimeZoneValidity("GMT35"));
    }

    @Test
    void checkTimeZoneValidity_ExistTimeZone_GetTrue() {
        assertEquals(true, TimeService.checkTimeZoneValidity("Europe/Luxembourg"));
    }
}