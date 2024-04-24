package pilhas;

public class PilhaItemLse {
    private NoItem top;
    private int quant;

    public PilhaItemLse() {
        this.top = null;
        this.quant = 0;
    }

    public boolean eVazia() {
        return (quant == 0 ? true : false);
    }

    public int size() {
        return this.quant;
    }

    public boolean push(Item novoItem) {
        NoItem novoNo = new NoItem(novoItem);
        if (this.eVazia()) {
            this.top = novoNo;
            this.quant++;
            return true;
        } else {
            novoNo.setNoAbaixo(this.top);
            this.top = novoNo;
            this.quant++;
            return true;
        }
    }
    public NoItem pop() {
        if (this.eVazia())
            return null;
        NoItem aux = this.top;
        this.top = this.top.getNoAbaixo();
        this.quant--;
        return aux;
    }
}
