package nz.bakuganrerolled;

class GateCard extends Card {

    private boolean isActive;
    private boolean isOpen;

    public GateCard(String name, boolean isActive, boolean isOpen) {
        super(name);
        this.isActive = isActive;
        this.isOpen = isOpen;
    }

    public void open() {
        this.isOpen = true;
        activate();
    }

    public void activate() {
        this.isActive = true;
    }

    public void nullify() {
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
