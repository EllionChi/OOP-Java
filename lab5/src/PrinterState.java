interface PrinterState {
    void handleState(Printer printer);
    String getStateName();
    boolean isApplicable(Printer printer);
}