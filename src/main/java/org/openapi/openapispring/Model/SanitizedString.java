package org.openapi.openapispring.Model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SanitizedString {

    private final String value;

    public SanitizedString(String value,String pattern){
        if (!PatternCheck(value, pattern) || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid product ID format: " + value);
        }
        this.value = value;
    }

   //    "^[A-Za-z0-9-]+$"   // Alphanumeric with dashes
    public boolean PatternCheck(String value,String pattern){
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(value);
        return matcher.matches();
    }

    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SanitizedString)) return false;
        SanitizedString that = (SanitizedString) o;
        return Objects.equals(this.getValue(), that.getValue()); // Compare values
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }

}
