public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy){
        switch(strategy){
            case "Chrome":
                return new Chrome();

            case "Firefox":
                return new Firefox();

            default:
                return null;
        }
    }
}
