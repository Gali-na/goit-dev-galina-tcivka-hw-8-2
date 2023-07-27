import service.TimeService;

public class Main {
    public static void main(String[] args) {
        System.out.println( TimeService.getTimeDateByUTC());
        System.out.println(TimeService.getTimeDateTimeZoneByZoneId("Europe/Luxembourg"));
        System.out.println(TimeService.checkTimeZoneValidity("GMT0"));
    }
}
