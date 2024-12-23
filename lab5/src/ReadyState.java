class ReadyState implements PrinterState {
    @Override
    public void handleState(Printer printer) {
        System.out.println(printer.getName() + " is ready to print.");
    }

    @Override
    public String getStateName() {
        return "Ready";
    }

    @Override
    public boolean isApplicable(Printer printer) {
        return printer.getInkLevel() > 10 && printer.getUsage() < 6;
    }
}