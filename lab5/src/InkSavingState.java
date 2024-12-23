class InkSavingState implements PrinterState {
    @Override
    public void handleState(Printer printer) {
        System.out.println(printer.getName() + " is in ink-saving mode.");
    }

    @Override
    public String getStateName() {
        return "Ink Saving";
    }

    @Override
    public boolean isApplicable(Printer printer) {
        return printer.getInkLevel() <= 10 && printer.getInkLevel() > 0;
    }
}