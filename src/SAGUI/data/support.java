// author @tuanlda78202
package SAGUI.data;

public class support { 

    // Constructor 
    public support() {
    }

    // Delete New Line Tab Spaces
    public String deleteNewLineTabSpaces(String str) {
        return str.replaceAll("[\\n\t]", "");
    }

    // Convert Str to Int Array 
    public int[] StrToArr(String str, String sepChar) throws Exception {
        String[] inp = str.replaceAll("\\[", "").replaceAll("\\]", "").split(sepChar);
        int[] arr = new int[inp.length];

        for (int i = 0; i < inp.length; i++) { 
            try {
                arr[i] = Integer.parseInt(inp[i]);
            } catch (Exception e) { 
                throw new Exception("This is not number");
            }
        }
        return arr;
    }

    public String ArrayToString(int[] arr, String sepChar) {
        String result = "[\n ";

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                result += arr[i] + sepChar + "\n ";
            } else {
                result += arr[i] + "\n]";
            }
        }

        return result;
    }

}