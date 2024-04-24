package pilhas;

public class PilhaItemLC {
    private Item[] pilha;
    private int quant;

    public PilhaItemLC() {
        this.pilha = new Item[10];
        this.quant = 0;
    }

    public boolean eVazia() {
        return (quant == 0 ? true : false);
    }

    public boolean eCheia() {
        return (quant == pilha.length ? true : false);
    }

    public int size() {
        return this.quant;
    }

    public void aumenta() {
        Item[] novaPilha = new Item[2 * this.pilha.length];
        for (int i = 0; i < this.quant; i++) {
            novaPilha[i] = this.pilha[i];
        }
        this.pilha = novaPilha;
    }

    public boolean push(Item novoItem) {
        if (eCheia())
            aumenta();
        //Trecho abaixo tbm serve para pilha vazia
        this.pilha[quant] = novoItem; //Quant -> primeira posição vazia
        this.quant++;
        return true;
    }

    public Item pop(){
        if (eVazia())
            return null;
        Item aux = pilha[quant - 1];
        this.quant--;
        return aux;
    }

    public Item top(){
        if (eVazia())
            return null;
        return this.pilha[quant - 1];
    }

}

