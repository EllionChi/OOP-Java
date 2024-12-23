class Printer {
    private final String name;
    private int usage;
    private double inkLevel;
    private boolean printing;
    private boolean isInMaintenance;
    private PrinterState state;

    public Printer(String name, double inkLevel) {
        this.name = name;
        this.inkLevel = inkLevel;
        this.usage = 0;
        this.printing = false;
        this.isInMaintenance = false;
        this.state = new ReadyState();
        updateState();
    }

    public void setState(PrinterState state) {
        this.state = state;
    }

    public void updateState() {
        if (isInMaintenance) {
            setState(new MaintenanceState());
            return;
        }

        PrinterState[] possibleStates = {
                new ReadyState(),
                new PrintingState(),
                new InkSavingState(),
                new MaintenanceState()
        };

        for (PrinterState possibleState : possibleStates) {
            if (possibleState.isApplicable(this)) {
                setState(possibleState);
                break;
            }
        }
    }

    public void print(boolean isColor) {
        if (isInMaintenance) {
            System.out.println(name + " cannot print while under maintenance.");
            return;
        }

        double requiredInk = isColor ? 20 : 10;
        if (inkLevel < requiredInk) {
            System.out.println(name + " does not have enough ink to print.");
            return;
        }

        printing = true;
        updateState();
        state.handleState(this);

        usage += isColor ? 2 : 1;
        inkLevel -= requiredInk;

        if (inkLevel < 0) {
            inkLevel = 0;
        }

        printing = false;
        updateState();
    }

    public void sendToMaintenance() {
        isInMaintenance = true;
        setState(new MaintenanceState());
        state.handleState(this);
    }

    public void exitMaintenance() {
        isInMaintenance = false;
        updateState();
    }

    public String getName() {
        return name;
    }

    public double getInkLevel() {
        return inkLevel;
    }

    public int getUsage() {
        return usage;
    }

    public String getState() {
        return state.getStateName();
    }

    public boolean isPrinting() {
        return printing;
    }
}