interface PrinterAdapter {
    void print(boolean isColor);
    String getName();
    double getInkLevel();
    String getState();
    void sendToMaintenance();
    int getUsage();
}