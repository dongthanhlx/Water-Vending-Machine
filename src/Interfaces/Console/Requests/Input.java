package Interfaces.Console.Requests;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    protected Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public InputData scan(String fieldName, ArrayList<String> rules)
    {
        String message = String.format("Enter %s : ", fieldName);
        String value;
        // formState: -1 | 0 | 1
        int formState = 1;
        String error = "";

        do {
            // Print form error
            if(formState == -1) {
                System.out.println(error);
                formState = 1;
            }

            // Print placeholder for input
            System.out.print(message);
            value = this.scanner.next();

            // Validate entered value
            if(rules.contains("required") && value.equals("")) {
                formState = -1;
                error = "The " + fieldName + " must not be empty";
                continue;
            }

            if(rules.contains("numeric") && !this.isNumeric(value)) {
                formState = -1;
                error = "The " + fieldName + " don't must numeric";
                continue;
            }

            if(rules.contains("string") && this.isNumeric(value)) {
                 formState = -1;
                 error = "The "+fieldName+" don't must string";
                 continue;
            }
            // range:2,7
            // range 2,7 => min = 2 ; max = 7;

            for(String rule: rules) {
                if (!rule.contains("range")) {
                     continue;
                }

                String rangeValue = rule.split(":")[1];
                int min = Integer.parseInt(rangeValue.split(",")[0]);
                int max = Integer.parseInt(rangeValue.split(",")[1]);
                int valueInput = Integer.parseInt(value);

                if (valueInput < min || valueInput > max) {
                    formState = -1;
                    error = "The "+ fieldName + " must (" + min + "-"+ max + ")";
                    break;
                }
            }

            if(formState != 1) {
                continue;
            }

            formState = 1;
        } while (formState != 1);

        return new InputData(value);
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
