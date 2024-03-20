package main;

public class ListaContigua {
    private Item[] vetor;
    private int quant;

    public ListaContigua() {
        this.vetor = new Item[10];
        this.quant = 0;
    }

    public ListaContigua(int tamanho) {
        this.vetor = new Item[tamanho];
        this.quant = 0;
    }

    public int tamanho () {
        return this.vetor.length;
    }
    public int getQuant() {
        return this.quant;
    }
    public boolean eVazia() {
        return (quant==0? true : false);
    }
    public boolean eCheia() {
        return (quant==vetor.length? true : false);
    }
    public Item getItem (int pos) {
        if (pos>=0 && pos<this.quant) {
            return this.vetor[pos];
        }
        return null;
    }

    public boolean insere (int pos, Item item) {
        if (pos<0 || pos>quant) {
            return false;
        }
        if (quant==this.vetor.length) {
            aumenta();
        }
        for (int i = quant; i> pos; i--) {
            this.vetor[i] = this.vetor[i-1];
        }
        this.vetor[pos] = item;
        this.quant++;
        return true;
    }

    public void insereInicio (Item item) {
        insere (0, item);
    }

    public void insereFinal (Item item) {
        if (quant==this.vetor.length) {
            aumenta();
        }
        this.vetor[quant] = item;
        this.quant++;
    }

    private void aumenta() {
        Item[] novo;
        novo = new Item[(int)(vetor.length*1.5)];
        for (int i=0; i<this.quant; i++) {
            novo[i] = this.vetor[i];
        }
        this.vetor = novo;
    }

    public int pesquisaPos (int cod) {
        for (int pos = 0; pos<quant; pos++) {
            if (this.vetor[pos].getCodigo() == cod) {
                return pos;
            }
        }
        return -1;
    }

    public Item pesquisa (int cod) {
        for (int pos = 0; pos<quant; pos++) {
            if (this.vetor[pos].getCodigo() == cod) {
                return this.vetor[pos];
            }
        }
        return null;
    }

    public Item remove (int cod) {
        Item aux;
        int pos = this.pesquisaPos(cod);
        if (pos==-1) {
            return null;
        }
        aux = this.vetor[pos];
        for (int i = pos; i<quant-1; i++) {
            this.vetor[i] = this.vetor[i+1];
        }
        this.vetor[quant] = null;
        this.quant--;
        return aux;
    }

    public Item removePos (int pos) {
        Item aux;
        if (pos<0 || pos>=quant) {
            return null;
        }
        aux = this.vetor[pos];
        for (int i = pos; i<quant-1; i++) {
            this.vetor[i] = this.vetor[i+1];
        }
        this.vetor[quant] = null;
        this.quant--;
        return aux;
    }

    public Item removePrim () {
        return removePos(0);
    }

    public Item removeUlt () {
        // return removePos (quant-1);
        Item aux;
        if (this.eVazia()) {
            return null;
        }
        aux = this.vetor[quant-1];
        this.vetor[quant-1]=null;
        quant--;
        return aux;

    }

    public ListaContigua concatenar(ListaContigua lista2) {
        ListaContigua concat = new ListaContigua(this.quant+lista2.getQuant());
        int i;
        for (i=0; i<this.quant; i++) {
            concat.insereFinal(this.vetor[i]);
        }
        for (i=0; i<lista2.quant; i++) {
            concat.insereFinal(lista2.vetor[i]);
        }
        return concat;
    }

    public String toString () {
        String aux = "";
        for (int i=0; i<this.quant; i++) {
            aux += this.vetor[i].toString()+"\n";
        }
        return aux;
    }

}
