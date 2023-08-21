package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String inputConfigureFile) {
        String[] inputStringToArr = inputConfigureFile.split("\n");

        return Arrays.stream(inputStringToArr)
                .filter(arrElement -> arrElement.startsWith("environment="))
                .map(arrElement2 -> arrElement2.replaceAll("environment=", ""))
                .map(arrElement3 -> arrElement3.replaceAll("\"", ""))
                .flatMap(longStringInStream -> Arrays.stream(longStringInStream.split(",")))
                .filter(arrElement4 -> arrElement4.startsWith("X_FORWARDED_"))
                .map(arrElement5 -> arrElement5.replaceAll("X_FORWARDED_", "").trim())
                .collect(Collectors.joining(","));
    }
}
//END
