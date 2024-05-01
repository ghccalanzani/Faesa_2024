package filas;

public class FilaItemLC {
    private Item[] fila;
    private int quant;

    public FilaItemLC() {
        this.fila = new Item[10];
        this.quant = 0;
    }

    public boolean eVazia(){
        return (this.quant == 0 ? true : false);
    }

    public boolean eCheia(){
        return (this.quant == this.fila.length ? true : false);
    }

    public int size(){
        return this.quant;
    }

    public void aumenta(){
        Item[] novaFila = new Item[2 * this.fila.length];
        for (int i = 0; i < this.quant; i++) {
            novaFila[i] = this.fila[i];
        }
        this.fila = novaFila;
    }

    public boolean enqueue(Item novoItem){
        if (eCheia())
            aumenta();
        this.fila[quant] = novoItem; //Quant -> primeira posição vazia
        this.quant++;
        return true;
    }

    public Item dequeue(){
        if(eVazia())
            return null;
        Item aux = this.fila[0];
        for(int i = 0; i < this.quant - 1; i++)
            fila[i] = fila[i + 1];
        this.quant--;
        return aux;
    }

    public Item peek(){
        if (eVazia())
            return null;
        return this.fila[0];
    }
}
