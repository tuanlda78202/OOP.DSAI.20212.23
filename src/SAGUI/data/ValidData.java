package SAGUI.data;

public class ValidData {
    // Check Empty
    // trim() eliminates leading and trailing spaces
    public boolean checkNullOrEmpty(String str) { 
        return str == null || str.trim().isEmpty();
    }

    // Check Number
    // "::" is called a method reference. It is basically a reference to a single method. 
    // I.e., it refers to an existing method by name
    public boolean checkNumber(String str) { 
        return str.chars().allMatch(Character::isDigit);
    }
}
