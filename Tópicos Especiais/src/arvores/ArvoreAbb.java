package arvores;

public class ArvoreAbb {
    private NoAbb raiz;
    private int quant;

    public ArvoreAbb() {
        this.raiz = null;
        this.quant = 0;
    }

    public int getQuant(){
        return this.quant;
    }

    public NoAbb getRaiz(){
        return this.raiz;
    }

    public boolean eVazia(){
        return (this.quant == 0);
    }

    public NoAbb pesquisa(int cod){
        return pesquisa(cod, this.raiz);
    }
    private NoAbb pesquisa(int cod, NoAbb no){
        if (no == null)
            return null;
        if (cod == no.getItem().getCodigo())
            return no;
        if (cod < no.getItem().getCodigo())
            return pesquisa(cod, no.getEsq());
        else
            return pesquisa(cod, no.getDir());
    }
    public boolean insere(Item item){
        NoAbb no = pesquisa(item.getCodigo());
        if (no != null)
            return false;
        raiz = insere(item, this.raiz);
        this.quant++;
        return true;
    }
    private NoAbb insere (Item item, NoAbb no){
        if (no == null)
            return (new NoAbb(item));
        if (item.getCodigo() < no.getItem().getCodigo())
            no.setEsq(insere(item, no.getEsq()));
        else
            no.setDir(insere(item, no.getDir()));
        return no;
    }

    public boolean remove(int num){
        if (pesquisa(num) == null)
            return false;
        raiz = remove(num, this.raiz);
        this.quant--;
        return true;
    }

    private NoAbb remove(int num, NoAbb no){
        if (no == null)
            return null;
        else if (num > no.getItem().getCodigo())
            no.setDir(remove(num, no.getDir()));
        else if (num < no.getItem().getCodigo())
            no.setEsq(remove(num, no.getEsq()));
        else {
            if (no.getEsq() == null)
                return no.getDir();
            else if (no.getDir() == null)
                return no.getEsq();
            else {
                NoAbb temp = maiorEsq(no.getEsq(), no.getEsq());
                no.setItem(temp.getItem());
                no.setEsq(remove(temp.getItem().getCodigo(), no.getEsq()));
            }
        }
        return no;
    }

    private NoAbb maiorEsq(NoAbb no, NoAbb maior){
        if (no.getDir() != null)
            return maiorEsq(no.getDir(), no.getDir());
        else
            return maior;
    }
}
