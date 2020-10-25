package me.zw.step02.controller;

public class ViewResolver {

    public String prefix;

    public String suffix;

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getView(String viewName) {
        return prefix + viewName + suffix;
    }
}
