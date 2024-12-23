class MaintenanceState implements PrinterState {
    @Override
    public void handleState(Printer printer) {
        System.out.println(printer.getName() + " is under maintenance.");
    }

    @Override
    public String getStateName() {
        return "Maintenance";
    }

    @Override
    public boolean isApplicable(Printer printer) {
        return printer.getUsage() >= 6 || printer.getInkLevel() < 6;
    }
}