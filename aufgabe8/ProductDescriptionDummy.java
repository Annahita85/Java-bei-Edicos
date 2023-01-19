package de.edicos.azubi.aufgabe8;

import java.util.LinkedHashMap;

public class ProductDescriptionDummy implements IProductDescription {

    private static int productCount = 0;

    private LinkedHashMap<String, String> attributesMap = new LinkedHashMap<>();

    private String name;

    public ProductDescriptionDummy(String... productAttributes) {
        name = "dummyProduct" + ++productCount;
        for(String s: productAttributes) {
            attributesMap.put(s,"value of " + s + " for " + name);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LinkedHashMap<String, String> getAttributes() {
        return attributesMap;
    }
}
