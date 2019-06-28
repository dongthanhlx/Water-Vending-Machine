package Interfaces.Console.Requests;

public class InputData {

    protected String value;

    public InputData(String value) {
        this.value = value;
    }

    public int toInt()
    {
        return Integer.parseInt(this.value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
