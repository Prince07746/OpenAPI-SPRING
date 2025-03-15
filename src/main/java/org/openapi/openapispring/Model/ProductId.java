package org.openapi.openapispring.Model;

public class ProductId extends SanitizedString{

    private static final String idPattern = "^[A-Za-z0-9-]{3,}$";

    public ProductId(String value){
        super(value,idPattern);
    }

}
