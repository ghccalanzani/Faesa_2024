package main;

public class LseItem {
    private NoItem prim, ult;
    private int quant;

    public LseItem() {
        this.prim = null;
        this.ult = null;
        this.quant = 0;
    }

    public NoItem getPrim() {
        return prim;
    }

    public void setPrim(NoItem prim) {
        this.prim = prim;
    }

    public NoItem getUlt() {
        return ult;
    }

    public void setUlt(NoItem ult) {
        this.ult = ult;
    }

    public int getQuant() {
        return quant;
    }

    public boolean eVazia() {
        return (quant == 0 ? true : false);
    }

    public boolean insereInicio(Item item) {
        return insere(0, item);
    }

    public boolean insereFinal(Item item) {
        NoItem novoNo = new NoItem(item);
        if (this.eVazia()) {
            prim = novoNo;
            ult = novoNo;
            quant++;
            novoNo.setProximoNo(null);
            return true;
        } else {
            ult.setProximoNo(novoNo);
            novoNo.setProximoNo(null);
            ult = novoNo;
            quant++;
            return true;
        }
    }

    public boolean insere(int pos, Item item) {
        NoItem novoNo;
        if (pos < 0 || pos >= quant) {  //Considerando que se colocar igual a quant NÃO é a mesma coisa que inserir no final
            return false;
        } else if (this.eVazia()) {
            novoNo = new NoItem(item);
            prim = novoNo;
            ult = novoNo;
            quant++;
            novoNo.setProximoNo(null);
            return true;
        } else if (pos == 0) {          //Inserir no início
            novoNo = new NoItem(item);
            novoNo.setProximoNo(prim);
            prim = novoNo;
            quant++;
            return true;
        } else{
            NoItem noPosAtual = prim;
            novoNo = new NoItem(item);
            for (int i = 0; i < pos - 1; i++) {            //Caminhar até posição anterior ao nó que será inserido
                noPosAtual = noPosAtual.getProximoNo();
            }
            novoNo.setProximoNo(noPosAtual.getProximoNo());
            noPosAtual.setProximoNo(novoNo);
            quant++;
            return true;
        }
    }

    public NoItem pesquisar(int codigoPesquisa) {
        if (this.eVazia())
            return null;
        NoItem noPosAtual = prim;
        for (int i = 0; i < quant; i++) {
            if (noPosAtual.getItem().getCodigo() == codigoPesquisa)
                return noPosAtual;
            noPosAtual = noPosAtual.getProximoNo();
        }
        return null;
    }

    public NoItem removerUltimo() {
        return remover(quant - 1);
    }

    public NoItem removerPrimeiro() {
        return remover(0);
    }

    public NoItem removerDeterminadoNo(int codigoPesquisa){
        int posNoCodigoPesquisa = -1;
        boolean achou = false;
        if (this.eVazia())
            return null;
        NoItem noPosAtual = prim;
        for (int i = 0; i < quant; i++) {
            if (noPosAtual.getItem().getCodigo() == codigoPesquisa) {
                posNoCodigoPesquisa = i;
                achou = true;
                break;
            }
            noPosAtual = noPosAtual.getProximoNo();
        }
        if(achou){
            return remover(posNoCodigoPesquisa);
        } else{
            return null;
        }
    }

    public NoItem remover(int pos) {
        if (this.eVazia())
            return null;
        NoItem noPosAtual = prim;
        NoItem noRemovido;
        if (pos < 0 || pos >= quant)
            return null;
        if (quant == 1) { //Caso só tenha um nó
            noRemovido = this.prim;
            prim = null;
            ult = null;
            quant--;
            return noRemovido;
        }
        if (pos == quant - 1) { //Caso o nó a ser removido seja o último
            for (int i = 0; i < pos - 1; i++)  //Caminhar até posição anterior ao nó que será removido
                noPosAtual = noPosAtual.getProximoNo();
            noRemovido = noPosAtual.getProximoNo();
            noPosAtual.setProximoNo(null);
            quant--;
            return noRemovido;
        }
        if (pos == 0) { //Caso o nó a ser removido seja o primeiro
            noRemovido = prim;
            prim = prim.getProximoNo();
            quant--;
            return noRemovido;
        }
        //Remover o k-ésimo nó
        for (int i = 0; i < pos - 1; i++)   //Caminhar até posição anterior ao nó que será removido
            noPosAtual = noPosAtual.getProximoNo();
        noRemovido = noPosAtual.getProximoNo();
        noPosAtual.setProximoNo(noRemovido.getProximoNo());
        quant--;
        return noRemovido;
    }

    public LseItem concatenar(LseItem novaLista) {
        if (this.eVazia()) {
            this.prim = novaLista.prim;
            this.ult = novaLista.ult;
            this.quant = novaLista.quant;
            return novaLista;
        }
        if (novaLista.eVazia())
            return this;

        this.ult.setProximoNo(novaLista.prim);
        this.ult = novaLista.ult;
        this.quant += novaLista.quant;
        return this;
    }
    public String mostrarElementos () {
        String temp = "";
        NoItem aux = this.prim;

        while (aux != null) {
            temp += aux.getItem().getCodigo() + " ";
            aux = aux.getProximoNo();
        }
        return temp;
    }
}