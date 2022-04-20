package com.company.menu;

public abstract class Menu {
    private String menuText;
    private String menuInstructions;

    public Menu(String menuText, String menuInstructions) {
        this.menuText = menuText;
        this.menuInstructions = menuInstructions;
    }

    public String getMenuText() {
        return menuText;
    }
    public String getMenuInstructions() {
        return menuInstructions;
    }

    public abstract void displayMenu();
    public abstract boolean validateMenuSelection(String aInput);

}
