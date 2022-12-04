package com.it_academy.onliner.rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Roll {
    String name_prefix;

    public String getName_prefix() {
        return name_prefix;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roll)) return false;

        Roll roll = (Roll) o;

        return getName_prefix() != null ? getName_prefix().equals(roll.getName_prefix()) : roll.getName_prefix() == null;
    }

    @Override
    public int hashCode() {
        return getName_prefix() != null ? getName_prefix().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "name_prefix='" + name_prefix + '\'' +
                '}';
    }
}
