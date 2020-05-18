package br.pro.hashi.ensino.desagil.aps.model;

public class And3Gate extends Gate {
    private final NandGate nand1, nand2, nand3, nand4;

    public And3Gate() {
        super("AND3", 3);

        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();
        nand4 = new NandGate();
    }

    @Override
    public boolean read() {
        return nand4.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex < 0 || inputIndex > 2) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        if (inputIndex == 2) {
            nand3.connect(0, emitter);
        } else {
            nand1.connect(inputIndex, emitter);
        }
        nand2.connect(0, nand1);
        nand2.connect(1, nand1);

        nand3.connect(1, nand2);

        nand4.connect(0, nand3);
        nand4.connect(1, nand3);
    }
}
