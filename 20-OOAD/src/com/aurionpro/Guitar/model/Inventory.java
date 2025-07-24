package com.aurionpro.Guitar.model;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Instrument> inventory = new LinkedList<>();

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = null;
        if (spec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, (GuitarSpec) spec);
        } else if (spec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, (MandolinSpec) spec);
        }
        inventory.add(instrument);
    }

    public List<Instrument> getInstruments() {
        return inventory;
    }
}
