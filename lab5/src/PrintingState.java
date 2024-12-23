class PrintingState implements PrinterState {
    @Override
    public void handleState(Printer printer) {
        System.out.println(printer.getName() + " is printing...");
    }

    @Override
    public String getStateName() {
        return "Printing";
    }

    @Override
    public boolean isApplicable(Printer printer) {
        return printer.isPrinting();
    }
}
