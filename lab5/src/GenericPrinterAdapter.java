class GenericPrinterAdapter implements PrinterAdapter {
    private final Printer printer;

    public GenericPrinterAdapter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(boolean isColor) {
        printer.print(isColor);
    }

    @Override
    public String getName() {
        return printer.getName();
    }

    @Override
    public double getInkLevel() {
        return printer.getInkLevel();
    }

    @Override
    public String getState() {
        return printer.getState();
    }

    @Override
    public void sendToMaintenance() {
        printer.sendToMaintenance();
    }

    @Override
    public int getUsage() {
        return printer.getUsage();
    }
}